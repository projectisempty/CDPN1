package io.jkaamer.cdpn;

import io.jkaamer.cdpn.compilerphases.Lexer;
import io.jkaamer.cdpn.compilerphases.Token;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.*;

/**
 * Main.java
 * This compiler is a tool that translates a program from one (fictional) language to C++ language.
 *
 * @author JKaamer
 * @version 1.7.0
 * @see io.jkaamer.cdpn.compilerphases.Lexer
 * @see io.jkaamer.cdpn.compilerphases.Token
 * @see java.io.File
 * @see java.io.FileWriter
 */
public class Main {

    public static void main(String[] args) {
        Scanner input;
        List<String> statementList; // A list for statement.
        Set<String> varSet; // A set for variables.

        String codeBase = "#include <iostream>\nusing namespace std;\nint main() {\n"; // base code in c++
        String statement = ""; // A String without initialize to save statements
        input = new Scanner(System.in);

        // Obtain the input file path and output file path
        System.out.printf("%s%n%s", "CDPN1 A SIMPLE COMPILER BY JKAAMER.", "Enter file path (input):");
        String filePath = input.next();
        // set output file path to save compiled program
        String outPath = filePath.substring(0, filePath.lastIndexOf("/") + 1) + "output.txt";
        input.close();

        Lexer lexer = new Lexer(filePath); // Initial a lexer object

        try (FileWriter writer = new FileWriter(outPath)) {
            statementList = new ArrayList<>();
            varSet = new HashSet<>();

            writer.write(codeBase);
            while (!lexer.isExausthed()) {
                switch (lexer.currentToken()) {
                    case TK_KEY_IN:
                        statement = "cin >>";
                        lexer.moveAhead();
                        if (lexer.currentToken() == Token.IDENTIFIER)
                            varSet.add(lexer.currentLexema());
                        break;
                    case TK_KEY_OUT:
                        statement = "cout <<";
                        lexer.moveAhead();
                        break;
                    case IDENTIFIER:
                        String variable = lexer.currentLexema();
                        statement = lexer.currentLexema();
                        lexer.moveAhead();
                        if (lexer.currentToken() == Token.TK_ASSIGN)
                            varSet.add(variable);
                        break;
                    case TK_ASSIGN:
                        statement = " = ";
                        lexer.moveAhead();
                        break;
                    case TK_PL:
                        statement = " ( ";
                        lexer.moveAhead();
                        break;
                    case TK_PR:
                        statement = " ) ";
                        lexer.moveAhead();
                        break;
                    case TK_PLUS:
                        statement = " + ";
                        lexer.moveAhead();
                        break;
                    case TK_MINUS:
                        statement = " - ";
                        lexer.moveAhead();
                        break;
                    case TK_MUL:
                        statement = " * ";
                        lexer.moveAhead();
                        break;
                    case TK_DIV:
                        statement = " / ";
                        lexer.moveAhead();
                        break;
                    case INTEGER:
                        statement = lexer.currentLexema();
                        lexer.moveAhead();
                        break;
                    case TK_SEMI:
                        statement = ";\n";
                        lexer.moveAhead();
                        break;
                    default:
                        statement = lexer.currentLexema();
                        lexer.moveAhead();
                }

                statementList.add(statement);
            }
            // Write to output file
            varSet.forEach(v -> {
                try {
                    writer.append("int ").append(v).append(";\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            statementList.forEach(s -> {
                try {
                    writer.append(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            writer.append("return 0;\n}");

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (lexer.isSuccessful()) {
            System.out.println("Successful!\nVersion 1.7.0");
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(new File(outPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(lexer.errorMessage());
        }
    }

}
