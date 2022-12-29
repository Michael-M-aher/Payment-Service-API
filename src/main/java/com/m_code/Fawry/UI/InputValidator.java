package com.m_code.Fawry.UI;

import java.util.ArrayList;
import java.util.Scanner;
import com.m_code.Fawry.Discount.Discount;
import com.m_code.Fawry.Discount.DiscountType;
import com.m_code.Fawry.Transaction.models.Transaction;
import com.m_code.Fawry.Services.AbstractService.AbstractService;

public class InputValidator {
    public static int validateInputServices(ArrayList<String> services) {
        Scanner sc = new Scanner(System.in);
        ListsPrinter.printServices(services);
        System.out.println(services.size() + 1 + ". " + "Search for a service");
        System.out.println(services.size() + 2 + ". " + "Go Back");
        System.out.println("Choose a service:");
        int serviceIndex = sc.nextInt();
        while (serviceIndex > services.size() + 2 || serviceIndex <= 0) {
            System.out.println("Invalid option");
            ListsPrinter.printServices(services);
            System.out.println(services.size() + 1 + ". " + "Search for a service");
            System.out.println(services.size() + 2 + ". " + "Go Back");
            System.out.println("Choose a service:");
            serviceIndex = sc.nextInt();
        }
        return serviceIndex;
    }

    public static int validateInputServicesProviders(ArrayList<AbstractService> services) {
        Scanner sc = new Scanner(System.in);
        ListsPrinter.printServicesProviders(services);
        System.out.println(services.size() + 1 + ". " + "Go Back");
        System.out.println("Choose a service provider:");
        int serviceIndex = sc.nextInt();
        while (serviceIndex > services.size() + 1 || serviceIndex <= 0) {
            System.out.println("Invalid option");
            ListsPrinter.printServicesProviders(services);
            System.out.println(services.size() + 1 + ". " + "Go Back");
            System.out.println("Choose a service provider:");
            serviceIndex = sc.nextInt();
        }
        return serviceIndex;
    }

    public static int validateInputDiscounts(ArrayList<Discount> discounts, DiscountType discountType) {
        Scanner sc = new Scanner(System.in);
        ListsPrinter.printDiscounts(discounts, discountType);
        System.out.println(discounts.size() + 1 + ". " + "Go Back");
        System.out.println("Choose a discount:");
        int discountIndex = sc.nextInt();
        while (discountIndex > discounts.size() + 1 || discountIndex <= 0) {
            System.out.println("Invalid option");
            ListsPrinter.printDiscounts(discounts, discountType);
            System.out.println(discounts.size() + 1 + ". " + "Go Back");
            System.out.println("Choose a discount:");
            discountIndex = sc.nextInt();
        }
        return discountIndex;
    }

    public static int validateInputTransactions(ArrayList<Transaction> transactions) {
        Scanner sc = new Scanner(System.in);
        ListsPrinter.printTransactions(transactions);
        System.out.println(transactions.size() + 1 + ". " + "Go Back");
        System.out.println("Choose transaction to refund:");
        int transactionIndex = sc.nextInt();
        while (transactionIndex > transactions.size() + 1 || transactionIndex <= 0) {
            System.out.println("Invalid option");
            ListsPrinter.printTransactions(transactions);
            System.out.println(transactions.size() + 1 + ". " + "Go Back");
            System.out.println("Choose transaction to refund:");
            transactionIndex = sc.nextInt();
        }
        return transactionIndex;
    }

    public static int validateInputRefundTransactions(ArrayList<Transaction> refundTransactions) {
        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < refundTransactions.size(); i++) {
//            System.out.println(i + 1 + ". " + refundTransactions.get(i).getUser() + " "
//                    + refundTransactions.get(i).getServiceProviderName().getServiceProviderName() + " "
//                    + refundTransactions.get(i).getAmount());
//        }
        System.out.println(refundTransactions.size() + 1 + ". " + "Go Back");
        System.out.println("Select a Refund request:");
        int refundIndex = sc.nextInt();
        while (refundIndex > refundTransactions.size() + 1 || refundIndex <= 0) {
            System.out.println("Invalid option");
//            for (int i = 0; i < refundTransactions.size(); i++) {
//                System.out.println(i + 1 + ". " + refundTransactions.get(i).getUser() + " "
//                        + refundTransactions.get(i).getServiceProviderName().getServiceProviderName() + " "
//                        + refundTransactions.get(i).getAmount());
//            }
            System.out.println(refundTransactions.size() + 1 + ". " + "Go Back");
            System.out.println("Select a Refund request:");
            refundIndex = sc.nextInt();
        }
        return refundIndex;
    }

    public static int validateInputUserMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "1. Recharge Wallet Balance\n2. Show Wallet Balance\n3. Show services\n4. show Transactions\n5. Logout");
        System.out.println("Choose an option:");
        int option = sc.nextInt();
        while (option > 5 || option <= 0) {
            System.out.println("Invalid Input");
            System.out.println(
                    "1. Recharge Wallet Balance\n2. Show Wallet Balance\n3. Show services\n4. show Transactions\n5. Logout");
            System.out.println("Choose an option:");
            option = sc.nextInt();
        }
        return option;
    }

    public static int validateInputAdminMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. List all refund requests\n2. Add Discounts\n3. Delete Discounts\n4. logout");
        System.out.println("Choose an option:");
        int option = sc.nextInt();
        while (option > 4 || option <= 0) {
            System.out.println("Invalid Input");
            System.out.println("1. List all refund requests\n2. Add Discounts\n3. Delete Discounts\n4. logout");
            System.out.println("Choose an option:");
            option = sc.nextInt();
        }
        return option;
    }

    public static int validateInputDiscountsMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Overall Discount \n2. Specific Discount \n3. GoBack");
        System.out.println("Choose an option:");
        int option = sc.nextInt();
        while (option > 3 || option <= 0) {
            System.out.println("Invalid option");
            System.out.println("1. Overall Discount \n2. Specific Discount \n3. GoBack");
            System.out.println("Choose an option:");
            option = sc.nextInt();
        }
        return option;
    }

    public static int validateInputPaymentMenu(Boolean Cod) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1- Credit Card");
        System.out.println("2- Personal Wallet");
        if (Cod) {
            System.out.println("3- Cash on delivery");
        }
        System.out.println("choose payment method: ");
        int option = sc.nextInt();
        while ((Cod && option > 3) || (!Cod && option > 2) || option <= 0) {
            System.out.println("Invalid option");
            System.out.println("1- Credit Card");
            System.out.println("2- Personal Wallet");
            if (Cod) {
                System.out.println("3- Cash on delivery");
            }
            System.out.println("choose payment method: ");
            option = sc.nextInt();
        }
        return option;
    }

    public static Boolean validateInputPayBill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you wish to pay the bill ?(y/n)");
        String option = sc.nextLine();
        while (!option.toLowerCase().equals("y") && !option.toLowerCase().equals("yes")
                && !option.toLowerCase().equals("n")
                && !option.toLowerCase().equals("no")) {
            System.out.println("Invalid option");
            System.out.println("Do you wish to pay the bill ?(y/n)");
            option = sc.nextLine();
        }
        if (option.toLowerCase().equals("y") || option.toLowerCase().equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public static int validateInputRefundStatus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Accept\n2. Reject");
        int option = sc.nextInt();
        while (option > 2 || option <= 0) {
            System.out.println("Invalid option");
            System.out.println("1. Accept\n2. Reject");
            option = sc.nextInt();
        }
        return option;
    }

    public static float validateInputDiscountPercentage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Discount percentage (number only)");
        int option = sc.nextInt();
        while (option > 100 || option <= 0) {
            System.out.println("Invalid Percentage");
            System.out.println("Enter the Discount percentage (number only)");
            option = sc.nextInt();
        }
        float discountAmount = (float) option / 100;
        return discountAmount;
    }

    public static float validateInputAmountRecharge() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount you want to recharge: ");
        float amount = sc.nextFloat();
        while (amount > 100000 || amount <= 0) {
            System.out.println("Invalid Amount");
            System.out.println("Enter the amount you want to recharge: ");
            amount = sc.nextFloat();
        }
        return amount;
    }

}
