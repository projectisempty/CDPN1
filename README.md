# CDPN1

پروژه درس اصول طراحی کامپایلر

## About Compiler

A compiler is a special program that translates a programming language's source code into machine code, bytecode or another programming language.

## Compiler Phases

The compilation process contains the sequence of various phases. Each phase takes source program in one representation 
and produces output in another representation. Each phase takes input from its previous stage. 

[phases of complier](https://byjus.com/gate/phases-of-complier-notes/).

## What will this program do?

The goal of this project is to build a simple compiler for a new and fictional language.
To produce a new language, you can take help from existing languages.

Consider a simple language with the following structure:
In these statements, operator is one of the operators + - * / and operand is an identifier or number, and num is an integer.

<blockquote><pre>
     operand = num;
     operand = operand operator operand;
</pre></blockquote>

Also, the in command reads a number from the user and puts it in the variable. The out command displays the value of a variable.
The structure of these commands is as follows:

<blockquote><pre>
    in operand;
    out operand;
</pre></blockquote><p>

This program reads expressions with the above structure from a file and translates them into c++ language and puts them in a file.
 
### Example

the following code is placed in the input text file of the compiler

```
in a;
in b;
c = a + b;
out c;
```

translates them into c++ language.

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

## License

The CDPN1 is open-sourced software licensed under the [Apache license](https://www.apache.org/licenses/LICENSE-2.0).