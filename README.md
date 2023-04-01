# CDPN1
پروژه درس اصول طراحی کامپایلر

## About Compiler

* A compiler is a translator that converts the high-level language into the machine language.
- High-level language is written by a developer and machine language can be understood by the processor.
+ Compiler is used to show errors to the programmer.
* The main purpose of compiler is to change the code written in one language without changing the meaning of the program.

## Compiler Phases

The compilation process contains the sequence of various phases. Each phase takes source program in one representation 
and produces output in another representation. Each phase takes input from its previous stage. 

* Lexical analyzer 
- Syntax analyzer 
+ Semantic analyzer 

### Lexical analyzer
Lexical analyzer phase is the first phase of compilation process. It takes source code as input. It reads the source program 
one character at a time and converts it into meaningful lexemes. Lexical analyzer represents these lexemes in the form of tokens.

### Syntax analyzer
Syntax analysis is the second phase of compilation process. It takes tokens as input and generates a parse tree as output. 
In syntax analysis phase, the parser checks that the expression made by the tokens is syntactically correct or not.

### Semantic analyzer
Semantic analysis is the third phase of compilation process. It checks whether the parse tree follows the rules of language. 
Semantic analyzer keeps track of identifiers, their types and expressions. The output of semantic analysis phase is the annotated tree syntax.

***

## What will this compiler do?
This program will act as a compiler and will read a text file that contains commands and code, then convert it to C++ and put it in another text file.

What commands does this source code include? 
What will each command do?

This compiler will compile the code of anlanguage that does not exist externally, which is very small and simple
 
**KEYWORDS** 

| _                | Keyword       |
| ---------------- |:-------------:|
| 1                | in            |
| 2                | out           |
 
**OPERATIONS** 

| Operation        | Mark          |
| ---------------- |:-------------:|
| Addition         | -             |
| Subtraction      | +             |
| multiplication   | *             |
| division         | /             |
| Remaining        | %             |
| assignment       | =             |
 
### Example of code
If the following code is placed in the input text file of the compiler, 
it must create and save the output file that contains the second code. 

```
in a;
in b;
c = a + b;
out c;
```

```C++
#include <iostream>
using namespace std;
int main() {
int a;
int b;
int c;
cin >>a;
cin >>b;
c=a+b;
cout <<c;
return 0;
}
```

***

## License

The CDPN1 is open-sourced software licensed under the [Apache license](https://www.apache.org/licenses/LICENSE-2.0).