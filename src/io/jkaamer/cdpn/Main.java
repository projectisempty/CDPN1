/**
 * Copyright 2023 Jkaamer ,All Rights Reserved.
 *
 *
 * @author jkaamer
 */
package io.jkaamer.cdpn;
//FIG 1.3 :Main.java
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		String codeBase = "#include <iostream>\nusing namespace std;\nint main() {\n";
		String statement = null;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the file path:");
		String filePath = input.next();
		input.close();
		
        Lexer lexer = new Lexer(filePath);
        
        try(FileWriter writer = new FileWriter("output/cdpn.txt")) {
        	
    		writer.write(codeBase);
    		
        	while (!lexer.isExausthed()) {
        		
        		// TODO inital variables
        		
        		String initVar = null;
            
        		// for (int i=0; i<lexer.currentLexema().length() ;i++) {
            	//	initVar = initVar.concat(lexer.currentLexema());
      			//	lexer.moveAhead();
            	// }
        		
            	if (lexer.currentToken() == Token.TK_KEY_IN) {
            		statement = "cin >>";
    				lexer.moveAhead();
            		if (lexer.currentToken() == Token.IDENTIFIER) {
    					initVar = "int " + lexer.currentLexema() + ";\n";	
    					writer.append(initVar);
    				}
    				
    			}else if (lexer.currentToken() == Token.TK_KEY_OUT) {
    				statement = "cout <<";
    				lexer.moveAhead();
    			}else if (lexer.currentToken() == Token.TK_SEMI) {
    				statement = ";\n";
    				lexer.moveAhead();
    			}else {
    				statement = lexer.currentLexema();
    				lexer.moveAhead();
    			}
            	writer.append(statement);
            }
        	
        	writer.append("return 0;\n}");

    	}catch (IOException e) {
			e.printStackTrace();
		}

        if (lexer.isSuccessful()) {
            System.out.println("Successfull!\nCopyright 2023 JKAAMER\n:D");
        } else {
            System.out.println(lexer.errorMessage());
        }
    }
}
