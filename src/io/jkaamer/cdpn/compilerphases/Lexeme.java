package io.jkaamer.cdpn.compilerphases;

/**
 * Lexeme is a sealed interface that permit Lexer.
 *
 * @see Token
 */
public sealed interface Lexeme permits Lexer {
    Token currentToken();

    String currentLexema();

    boolean isSuccessful();

    String errorMessage();

    boolean isExausthed();
}
