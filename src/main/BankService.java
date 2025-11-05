package main;

import java.sql.*;
import java.util.*;

public class BankService {
    private Connection conn;

    public BankService() {
        conn = DatabaseConnection.getConnection();
    }

    public void registerAccount() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name: ");
        String name = in.nextLine();

        if (!Validator.isValidName(name)) {
            Validator.printError("Invalid name!");
            return;
        }

        System.out.println("Enter Contact (10 digits): ");
        String contact = in.nextLine();

        if (!Validator.isValiContact(contact)) {
            System.out.println("Invalid Contact Number!!");
            return;
        }

        System.out.println("Enter Address: ");
        String address = in.nextLine();

        if (!Validator.isValidAddress(address)) {
            System.out.println("Address must be at least 5 characters long!");
            return;
        }

        try {
            String check = "SELECT * FROM accounts WHERE contact =?";
            PreparedStatement prepCheck = conn.prepareStatement(check);

            prepCheck.setString(1, contact);
            ResultSet res = prepCheck.executeQuery();

            if (res.next()) {
                Validator.printError("Account with this contact already exists!");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        long accountNumber = System.currentTimeMillis();
        double balance = 0.0;

        try {
            String query = "INSERT INTO accounts (name, contact, address, account_number, balance) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertprep = conn.prepareStatement(query);
            insertprep.setString(1, name);
            insertprep.setString(2, contact);
            insertprep.setString(3, address);
            insertprep.setLong(4, accountNumber);
            insertprep.setDouble(5, balance);
            insertprep.executeUpdate();

            Validator.printSuccess("Account Created Successfully!");
            System.out.println("Your Account Number is: " + accountNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void depositMoney(long accNo, double amount) {
        if (!Validator.isValidAmount(amount)) {
            Validator.printError("Deposit amount must be greater than 0!");
            return;
        }

        try {
            String query = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
            PreparedStatement depositPrep = conn.prepareStatement(query);

            depositPrep.setDouble(1, amount);
            depositPrep.setLong(2, accNo);

            int rows = depositPrep.executeUpdate();

            if (rows > 0) {
                Validator.printSuccess("₹" + amount + " Deposited Successfully!");
            } else {
                Validator.printError("Account not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdrawMoney(long accNo, double amount) {
        if (!Validator.isValidAmount(amount)) {
            Validator.printError("Withdrawal amount must be greater than 0!");
            return;
        }

        try {
            String query = "SELECT balance FROM accounts WHERE account_number = ?";
            PreparedStatement getUserPrep = conn.prepareStatement(query);

            getUserPrep.setLong(1, accNo);

            ResultSet res = getUserPrep.executeQuery();

            if (res.next()) {
                double balance = res.getDouble("balance");

                if (balance >= amount) {
                    String updateQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
                    PreparedStatement withdrawPrep = conn.prepareStatement(updateQuery);
                    withdrawPrep.setDouble(1, amount);
                    withdrawPrep.setLong(2, accNo);
                    withdrawPrep.executeUpdate();

                    Validator.printSuccess("₹" + amount + " Withdrawn Successfully!");
                    System.out.println("Remaining Balance: ₹" + (balance - amount));
                } else {
                    Validator.printError("Insufficient balance!");
                }
            } else {
                Validator.printError("Account not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkBalance(long accNo) {
        try {
            String query = "SELECT name, balance FROM accounts WHERE account_number = ?";
            PreparedStatement checkPrep = conn.prepareStatement(query);
            checkPrep.setLong(1, accNo);

            ResultSet res = checkPrep.executeQuery();

            if (res.next()) {
                String name = res.getString("name");
                double balance = res.getDouble("balance");
                Validator.printInfo("Account Holder: " + name);
                System.out.println("Current Balance: ₹" + balance);
            } else {
                Validator.printError("Account not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
