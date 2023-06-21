package io.jkaamer.cdpn.compilerphases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Token.java
 * identifier: names the programmer chooses
 * keyword: names already in the programming language
 * operator: symbols that operate on arguments and produce results
 *
 * @see java.util.regex.Pattern
 * @see java.util.regex.Matcher
 * @see io.jkaamer.cdpn.compilerphases.Lexer
 */

public enum Token {

    TK_MINUS("-"),
    TK_PLUS("\\+"),
    TK_MUL("\\*"),
    TK_DIV("/"),
    TK_ASSIGN("="),
    TK_SEMI(";"),
    TK_KEY_IN("in"),
    TK_KEY_OUT("out"),
    TK_PL("\\("),
    TK_PR("\\)"),

    REAL("(\\d*)\\.\\d+"),
    STRING("\"[^\"]+\""),
    INTEGER("\\d"),
    IDENTIFIER("\\w+");

    private final Pattern pattern;

    /**
     * Token constructor
     * It's receive a string value for initialize
     *
     * @param regex The characters sequence to be matched
     * @throws java.util.regex.PatternSyntaxException
     */
    Token(String regex) {
        pattern = Pattern.compile("^" + regex);
    }

    /**
     * endOfMatch
     * Returns the offset after the last character matched
     *
     * @param s The character sequence to be matched.
     * @return {@code -1} if, and only if, a subsequence of the input
     * sequence matches this matcher's pattern is {@code false}.
     * @throws IllegalStateException
     */
    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }
        return -1;
    }
}
