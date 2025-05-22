# DFA-Finite-Automaton-Lexical-Analyzer

This project implements a deterministic finite automaton (DFA) to perform lexical analysis for a basic arithmetic calculator. The analyzer processes strings representing arithmetic expressions and converts them into a sequence of tokens (e.g., numbers and operators).


The following expressions are valid:
1. A valid number is a valid expression. 
2. Any valid expression, followed by an operator, followed by a valid number.
3. The operators and numbers may or may not be separated by white space.

Numbers will be in the following format:
1. A string of digits possibly followed by a decimal point and a non-empty string of digits. 
2. If there is a decimal point, the string before the decimal point should consist only of 0.
3. If the number starts with 0', it is either just 0, or 0.[something] where the [something] is a string of digits.

<img width="466" alt="image" src="https://github.com/user-attachments/assets/a3b9eba0-026a-4bb7-a89b-f90ab42b6ea6" />
