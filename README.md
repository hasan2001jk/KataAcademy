# Description

This application is a simple calculator that can handle both Arabic and Roman numerals. The main functionality of the application is to carry out basic arithmetic operations such as addition, subtraction, multiplication, and division. The application is built in Java and utilizes different functions to handle the calculations.

# Usage

To use this application, the user needs to input an expression in the following format: "a *-+/ b". The application supports both Arabic (from 1 to 10) and Roman numerals (from I to X). Arithmetic operations supported are addition (+), subtraction (-), multiplication (*) and division (/).

# Functions

- `romanToInt(String s)`: Converts Roman numerals to Arabic numerals.
- `intToRoman(int num)`: Converts Arabic numerals to Roman numerals.
- `calc(String input)`: Takes the input expression and performs the calculation.

# Testing

To test this application, you can input various test expressions. Make sure to use correct formatting and supported numbers. Some test examples could be:

- "2 + 3" (Expected output: "5")
- "V * II" (Expected output: "X")
- "10 / 5" (Expected output: "2")
- "IX - III" (Expected output: "VI")

# How to Run

You should run the `main` function of the `Main` class. When the application starts, it will prompt you to enter an expression. After entering the expression, press enter and the application will display the result.

# Note

- The Roman numeral calculations will always return the result in Roman numerals.
- The Arabic numeral calculations will always return the result in Arabic numerals.
- The application does not support mixed numeral types (e.g. "2 + II" is not valid).
