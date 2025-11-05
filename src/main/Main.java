package main;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner getinput = new Scanner(System.in);
        BankService bankService = new BankService();
        // ManagerService managerService = new ManagerService();

        System.out.println("======================================");
        System.out.println("  WELCOME TO SmartBANK MANAGEMENT SYSTEM  ");
        System.out.println("======================================");

        boolean running = true;

        while (running) {
            System.out.println("\n==== MAIN MENU ====");
            System.out.println("1  New Registration");
            System.out.println("2  Deposit Money");
            System.out.println("3  Withdraw Money");
            System.out.println("4  Check Balance");
            // System.out.println("5 Manager Login");
            System.out.println("5  Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(getinput.nextLine());
            } catch (Exception e) {
                Validator.printError("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    bankService.registerAccount();
                    break;

                case 2:
                    System.out.println("Enter Account Number: ");
                    long depAcc = Long.parseLong(getinput.nextLine());
                    System.out.println("Enter Amount to Deposit: ");
                    double depAmt = Double.parseDouble(getinput.nextLine());

                    bankService.depositMoney(depAcc, depAmt);
                    break;

                case 3:
                    System.out.println("Enter Account Number: ");
                    long withAcc = Long.parseLong(getinput.nextLine());
                    System.out.print("Enter Amount to Withdraw: ");
                    double withAmt = Double.parseDouble(getinput.nextLine());

                    bankService.withdrawMoney(withAcc, withAmt);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    long balAcc = Long.parseLong(getinput.nextLine());
                    bankService.checkBalance(balAcc);
                    break;

                case 5:
                    System.out.println("Thank you for using  SmartBank!");
                    running = false;
                    break;

                default:
                    Validator.printError("Invalid choice! Please select 1-5.");
                    break;
            }
        }
        getinput.close();
    }
}