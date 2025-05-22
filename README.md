# DFA-Finite-Automaton-Lexical-Analyzer

This project implements a deterministic finite automaton (DFA) to perform lexical analysis for a basic arithmetic calculator. The analyzer processes strings representing arithmetic expressions and converts them into a sequence of tokens (e.g., numbers and operators).


The following expressions are valid:

A valid number is a valid expression.
Any valid expression, followed by an operator, followed by a valid number.
The operators and numbers may or may not be separated by white space.
Numbers will be in the following format:

A string of digits possibly followed by a decimal point and a non-empty string of digits.
If there is a decimal point, the string before the decimal point should consist only of 0.
If the number starts with 0', it is either just 0, or 0.[something] where the [something] is a string of digits.
