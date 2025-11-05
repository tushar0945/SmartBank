package main;

public class Account {
    private int id;
    private String name;
    private String contact;
    private String address;
    private long accountNumber;
    private double balance;

    public Account() {
    }

    public Account(String name, String contact, String address, long accountNumber, double balance) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account(int id, String name, String contact, String address, long accountNumber, double balance) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\n===== ACCOUNT DETAILS =====" +
                "\nAccount Number : " + accountNumber +
                "\nAccount Holder : " + name +
                "\nContact        : " + contact +
                "\nAddress        : " + address +
                "\nBalance        : ₹" + balance +
                "\n===========================\n";
    }
}
