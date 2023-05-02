package io.jkaamer.cdpn;
//FIG 1.5 :Main.java
/**
 * @author Jkaamer
 * @version 1.6.2
 * @since March, 2023
 */

import io.jkaamer.cdpn.compilerphases.Lexer;
import io.jkaamer.cdpn.compilerphases.Token;
import io.jkaamer.cdpn.exeptions.SyntaxException;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.*;

public class Main {

    private static Scanner input;
    private static File file;
    private static List<String> statementList; // A list for statement.
    private static Set<String> varSet; // A set for variables.

    public static void main(String[] args) {

        String codeBase = "#include <iostream>\nusing namespace std;\nint main() {\n"; // base code in c++
        String statement = ""; // A String without initialize to save statements
        input = new Scanner(System.in);

        // Obtain the input file path and output file path
        System.out.printf("%s%n%s", "CDPN1 A SIMPLE COMPILER BY JKAAMER.", "Enter file path (input):");
        String filePath = input.next();
        // set output file path to save compiled program
        String outPath = filePath.substring(0, filePath.lastIndexOf("/") + 1) + "output.txt";
        input.close();

        try {
            checkSyntax(filePath);
        } catch (FileNotFoundException | SyntaxException e) {
            System.out.println(e);
            System.exit(1);
        }


        Lexer lexer = new Lexer(filePath);
        List<String> arr = new ArrayList<>();

        try (FileWriter writer = new FileWriter(outPath)) {

            statementList = new ArrayList<>();
            varSet = new HashSet<>();

            writer.write(codeBase);
            while (!lexer.isExausthed()) {
                switch (lexer.currentToken()) {
                    case TK_KEY_IN:
                        statement = "cin >>";
                        lexer.moveAhead();
                        if (lexer.currentToken() == Token.IDENTIFIER) {
                            varSet.add(lexer.currentLexema());
                        }
                        break;
                    case TK_KEY_OUT:
                        statement = "cout <<";
                        lexer.moveAhead();
                        if (lexer.currentToken() == Token.IDENTIFIER) {
                            varSet.add(lexer.currentLexema());
                        }
                        break;
                    case TK_ASSIGN:
                        statement = " = ";
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
                /*
                if (lexer.currentToken() == Token.TK_KEY_IN) {
                    statement = "cin >>";
                    lexer.moveAhead();
                    if (lexer.currentToken() == Token.IDENTIFIER) {
                        varSet.add(lexer.currentLexema());
                    }
                } else if (lexer.currentToken() == Token.TK_KEY_OUT) {
                    statement = "cout <<";
                    lexer.moveAhead();
                    if (lexer.currentToken() == Token.IDENTIFIER) {
                        varSet.add(lexer.currentLexema());
                    }
                } else if (lexer.currentToken() == Token.TK_SEMI) {
                    statement = ";\n";
                    lexer.moveAhead();
                } else {
                    statement = lexer.currentLexema();
                    lexer.moveAhead();
                }
                 */
                statementList.add(statement);
            }
            // Write to output file
            for (String v : varSet) {
                writer.append("int " + v + ";\n");
            }
            for (String s : statementList) {
                writer.append(s);
            }
            writer.append("return 0;\n}");

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (lexer.isSuccessful()) {
            System.out.println("Successful!\nVersion 1.6.2");
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

    // Check semi is excepted or not
    private static void checkSyntax(String path) throws FileNotFoundException, SyntaxException {

        file = new File(path);
        input = new Scanner(file);
        int lineNum = 0;
        while (input.hasNextLine()) {
            lineNum += 1;
            String stateLine = input.nextLine();
            if (!stateLine.endsWith("" + ';')) {
                throw new SyntaxException("; is excepted:" + lineNum);
            }
        }
    }
}
