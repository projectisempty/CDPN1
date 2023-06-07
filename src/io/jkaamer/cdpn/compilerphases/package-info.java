/**
 * <h2>Lexeme</h2>
 * <p>A lexeme is a sequence of characters in the source program that matches the pattern for a token and is identified
 * by the lexical analyzer as an instance of that token</p>
 * <p>Some authors term this a "token", using "token" interchangeably to represent the string being tokenized, and the
 * token data structure resulting from putting this string through the tokenization process.</p>
 * <p>The word lexeme in computer science is defined differently than lexeme in linguistics. A lexeme in computer science
 * roughly corresponds to a word in linguistics (not to be confused with a word in computer architecture), although in
 * some cases it may be more similar to a morpheme. In some natural languages (for example, in English), the linguistic
 * lexeme is similar to the lexeme in computer science, but this is generally not true (for example, in Chinese, it is
 * highly non-trivial to find word boundaries due to the lack of word separators).</p>
 * <br>
 * <h2>Token</h2>
 * <p>A lexical token or simply token is a string with an assigned and thus identified meaning. It is structured as a
 * pair consisting of a token name and an optional token value. The token name is a category of lexical unit.Common
 * token names are</p>
 * <ul>
 *   <li>identifier: names the programmer chooses.</li>
 *   <li>keyword: names already in the programming language.</li>
 *   <li>operator: symbols that operate on arguments and produce results.</li>
 * </ul>
 *
 * @author Jkaamer
 * @since 1.0.0
 * @see io.jkaamer.cdpn.compilerphases.Lexer
 * @see io.jkaamer.cdpn.compilerphases.Token
 * @version 1.7.0
 */
package io.jkaamer.cdpn.compilerphases;
/*
In computer science, lexical analysis, lexing or tokenization is the process of converting a sequence of characters
(such as in a computer program or web page) into a sequence of lexical tokens (strings with an assigned and thus
identified meaning). A program that performs lexical analysis may be termed a lexer, tokenizer,[1] or scanner, although
scanner is also a term for the first stage of a lexer. A lexer is generally combined with a parser, which together
analyze the syntax of programming languages, web pages, and so forth.

 */