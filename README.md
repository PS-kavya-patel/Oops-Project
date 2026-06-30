# Personal Expense Tracker

A Java console application that demonstrates core Object-Oriented Programming concepts such as:
- Functions
- Classes and Objects
- Encapsulation
- Inheritance
- Polymorphism
- Debugging

## Features
- Add expense
- View all expenses
- Update expense
- Delete expense
- Search expense by title or category
- Calculate total expense
- Exit

## OOP Concepts Used
- Encapsulation: private fields with getters/setters in the Expense and Person classes
- Inheritance: User extends Person
- Polymorphism: User overrides displayDetails()
- Classes and Objects: Person, User, Expense, ExpenseManager, ExpenseManagerMain
- Functions: addExpense(), viewExpenses(), updateExpense(), deleteExpense(), searchExpense(), calculateTotalExpense()

## Project Structure
- src/expensetracker/Person.java
- src/expensetracker/User.java
- src/expensetracker/Expense.java
- src/expensetracker/ExpenseManager.java
- src/expensetracker/ExpenseManagerMain.java

## Debugging Report
A complete debugging report is available in:
- docs/DEBUGGING_REPORT.md
- docs/OOP_CHECKLIST.md

## How to Run
1. Open a terminal in this folder.
2. Compile the project:
   ```bash
   javac -d out src/expensetracker/*.java
   ```
3. Run the program:
   ```bash
   java -cp out expensetracker.ExpenseManagerMain
   ```

If Java is not installed, install JDK 21 or later first.

## GitHub Submission Note
Upload this project to GitHub and share the repository link for review.
