package expensetracker;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private final List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("---------------------------------------------------------");
        System.out.printf("%-5s %-15s %-15s %-12s %-12s%n", "ID", "Title", "Category", "Amount", "Date");
        System.out.println("---------------------------------------------------------");
        for (Expense expense : expenses) {
            System.out.printf("%-5d %-15s %-15s %-12.2f %-12s%n",
                    expense.getId(),
                    expense.getTitle(),
                    expense.getCategory(),
                    expense.getAmount(),
                    expense.getDate());
        }
        System.out.println("---------------------------------------------------------");
    }

    public boolean updateExpense(int id, double newAmount) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                expense.setAmount(newAmount);
                return true;
            }
        }
        return false;
    }

    public boolean deleteExpense(int id) {
        return expenses.removeIf(expense -> expense.getId() == id);
    }

    public List<Expense> searchByTitle(String title) {
        List<Expense> results = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getTitle().equalsIgnoreCase(title)) {
                results.add(expense);
            }
        }
        return results;
    }

    public List<Expense> searchByCategory(String category) {
        List<Expense> results = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                results.add(expense);
            }
        }
        return results;
    }

    public double calculateTotalExpense() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }
}
