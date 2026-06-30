package expensetracker;

import java.util.List;
import java.util.Scanner;

public class ExpenseManagerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========== PERSONAL EXPENSE TRACKER ==========");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        User user = new User(name, email);
        ExpenseManager expenseManager = new ExpenseManager();

        System.out.println();
        user.displayDetails();
        System.out.println();

        int choice;
        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = readInt(scanner);

            switch (choice) {
                case 1 -> addExpense(scanner, expenseManager);
                case 2 -> expenseManager.viewExpenses();
                case 3 -> updateExpense(scanner, expenseManager);
                case 4 -> deleteExpense(scanner, expenseManager);
                case 5 -> searchExpense(scanner, expenseManager);
                case 6 -> System.out.println("Total Expense = ₹" + String.format("%.2f", expenseManager.calculateTotalExpense()));
                case 7 -> System.out.println("Exiting application. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 7);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. Update Expense");
        System.out.println("4. Delete Expense");
        System.out.println("5. Search Expense");
        System.out.println("6. Calculate Total Expense");
        System.out.println("7. Exit");
    }

    private static void addExpense(Scanner scanner, ExpenseManager expenseManager) {
        System.out.print("Enter Expense Title: ");
        String title = scanner.nextLine();
        double amount = readDouble(scanner, "Enter Amount: ");
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Date (DD-MM-YYYY): ");
        String date = scanner.nextLine();

        Expense expense = new Expense(title, amount, category, date);
        expenseManager.addExpense(expense);
        System.out.println("Expense added successfully!");
    }

    private static void updateExpense(Scanner scanner, ExpenseManager expenseManager) {
        int id = readInt(scanner, "Enter Expense ID: ");
        double newAmount = readDouble(scanner, "Enter New Amount: ");

        boolean updated = expenseManager.updateExpense(id, newAmount);
        if (updated) {
            System.out.println("Expense Updated Successfully!");
        } else {
            System.out.println("Expense not found.");
        }
    }

    private static void deleteExpense(Scanner scanner, ExpenseManager expenseManager) {
        int id = readInt(scanner, "Enter Expense ID: ");
        boolean deleted = expenseManager.deleteExpense(id);
        if (deleted) {
            System.out.println("Expense Deleted Successfully!");
        } else {
            System.out.println("Expense not found.");
        }
    }

    private static void searchExpense(Scanner scanner, ExpenseManager expenseManager) {
        System.out.println("Search by: 1. Title  2. Category");
        int searchChoice = readInt(scanner, "Enter your choice: ");
        System.out.print("Enter search term: ");
        String term = scanner.nextLine();

        List<Expense> results;
        if (searchChoice == 1) {
            results = expenseManager.searchByTitle(term);
        } else if (searchChoice == 2) {
            results = expenseManager.searchByCategory(term);
        } else {
            System.out.println("Invalid search choice.");
            return;
        }

        if (results.isEmpty()) {
            System.out.println("No matching expenses found.");
            return;
        }

        System.out.println("Matching expenses:");
        for (Expense expense : results) {
            System.out.println(expense.getTitle() + " | " + expense.getCategory() + " | ₹" + expense.getAmount());
        }
    }

    private static int readInt(Scanner scanner) {
        String value = scanner.nextLine().trim();
        while (!value.matches("-?\\d+")) {
            System.out.print("Please enter a valid number: ");
            value = scanner.nextLine().trim();
        }
        return Integer.parseInt(value);
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return readInt(scanner);
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String value = scanner.nextLine().trim();
        while (true) {
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
                value = scanner.nextLine().trim();
            }
        }
    }
}
