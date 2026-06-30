package expensetracker;

public class Expense {
    private static int nextId = 1;

    private int id;
    private String title;
    private double amount;
    private String category;
    private String date;

    public Expense(String title, double amount, String category, String date) {
        this.id = nextId++;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
