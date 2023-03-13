/**
 * Copyright 2023 Jkaamer ,All Rights Reserved.
 *
 * 
 * @author jkaamer
 */
package io.jkaamer.cdpn;
// FIG 1.1 :Token.java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {

    TK_MINUS ("-"), 
    TK_PLUS ("\\+"), 
    TK_MUL ("\\*"), 
    TK_DIV ("/"), 
    TK_ASSIGN ("="),
    TK_SEMI (";"),  
    TK_KEY_IN ("in"),
    TK_KEY_OUT ("out"),

    REAL ("(\\d*)\\.\\d+"),
    STRING ("\"[^\"]+\""),
    INTEGER ("\\d"), 
    IDENTIFIER ("\\w+");
	
    private final Pattern pattern;
    
    Token(String regex) {
        pattern = Pattern.compile("^" + regex);
    }

    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }
        return -1;
    }
}
