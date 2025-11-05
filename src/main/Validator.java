package main;

public class Validator {
    public static boolean isValidName(String name) {
        return name != null && name.matches("^[A-Za-z ]{3,}$");
    }

    public static boolean isValiContact(String contact) {
        return contact != null && contact.matches("^[0-9]{10}$");
    }

    public static boolean isValidAddress(String address) {
        return address != null && address.trim().length() >= 5;
    }

    public static boolean isValidAmount(double ammount) {
        return ammount > 0;
    }

    public static void printError(String message) {
        System.out.println("\u001B[31m " + message + "\u001B[0m");
    }

    public static void printSuccess(String message) {
        System.out.println("\u001B[32m " + message + "\u001B[0m");
    }

    public static void printInfo(String message) {
        System.out.println("\u001B[34mℹ " + message + "\u001B[0m");
    }
}
