package expensetracker;

public class User extends Person {
    public User(String name, String email) {
        super(name, email);
    }

    @Override
    public void displayDetails() {
        System.out.println("User details:");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }
}
