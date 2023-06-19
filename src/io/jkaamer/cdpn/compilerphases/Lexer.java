package io.jkaamer.cdpn.compilerphases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Lexer.java
 * A lexeme is a sequence of characters in the source program that matches the pattern for a token and is identified
 * by the lexical analyzer as an instance of that token.
 *
 * @see io.jkaamer.cdpn.compilerphases.Token
 * @see java.nio.file.Files
 * @see java.util.stream.Stream
 * @see java.lang.StringBuilder
 */

public final class Lexer {

    private StringBuilder input = new StringBuilder();
    private Token token;
    private String lexema;
    private boolean exausthed = false;

    private String errorMessage = "";
    private Set<Character> blankChars = new HashSet<Character>(); // A set for white spaces

    /**
     * Lexer constructor
     * It's receive a string path for initialize
     *
     * @param filePath A path string
     * @throws java.nio.file.InvalidPathException
     * @throws IOException
     */
    public Lexer(String filePath) {

        try (Stream<String> st = Files.lines(Paths.get(filePath))) {
            st.forEach(input::append);
        } catch (IOException ex) {
            exausthed = true;
            errorMessage = "Could not read file: " + filePath;
            return;
        }

        blankChars.add('\r');
        blankChars.add('\n');
        blankChars.add((char) 8);
        blankChars.add((char) 9);
        blankChars.add((char) 11);
        blankChars.add((char) 12);
        blankChars.add((char) 32);

        moveAhead();
    }

    /**
     * moveAhead
     * <p>
     * {@link #exausthed}
     * {@link #ignoreWhiteSpaces()}
     * {@link #findNextToken()}
     * {@link #errorMessage}
     */
    public void moveAhead() {
        if (exausthed) {
            return;
        }

        if (input.length() == 0) {
            exausthed = true;
            return;
        }

        ignoreWhiteSpaces();

        if (findNextToken()) {
            return;
        }

        exausthed = true;

        if (input.length() > 0) {
            errorMessage = "Unexpected symbol: '" + input.charAt(0) + "'";
        }
    }

    /**
     * ignoreWhiteSpaces
     * Delete {@link #blankChars} for ignore them in compile
     */
    private void ignoreWhiteSpaces() {
        int charsToDelete = 0;

        while (blankChars.contains(input.charAt(charsToDelete))) {
            charsToDelete++;
        }

        if (charsToDelete > 0) {
            input.delete(0, charsToDelete);
        }
    }

    /**
     * findNextToken
     *
     * @return {@code true} if local variable end is {@code -1}, otherwise
     * {@code false}
     */
    private boolean findNextToken() {

        for (Token t : Token.values()) {
            int end = t.endOfMatch(input.toString());

            if (end != -1) {
                token = t;
                lexema = input.substring(0, end);
                input.delete(0, end);
                return true;
            }
        }

        return false;
    }

    /**
     * currentToken
     *
     * @return {@link #token}
     */
    public Token currentToken() {
        return token;
    }

    /**
     * currentLexema
     *
     * @return {@link #lexema}
     */
    public String currentLexema() {
        return lexema;
    }

    /**
     * isSuccessful
     * Checks that errorMessage is empty or not
     *
     * @return {@code true} if {@link #errorMessage} is {@code 0}, otherwise
     * {@code false}
     */
    public boolean isSuccessful() {
        return errorMessage.isEmpty();
    }

    /**
     * errorMessage
     *
     * @return {@link #errorMessage}
     */
    public String errorMessage() {
        return errorMessage;
    }

    /**
     * isExausthed
     *
     * @return {@link #exausthed}
     */
    public boolean isExausthed() {
        return exausthed;
    }

}
