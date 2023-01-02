package Simple_banking_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static List<Account> accounts = new ArrayList<>();


    public static void main(String[] args) {

        int choice = 1;

        while (choice != 0) {
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("3. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Account random = new Account();
                    accounts.add(random);
                    random.createCard();
                    random.createPIN();
                    printCardAndPin(random);
                    break;
                case 2:
                    System.out.println("Enter card number:");
                    String cardNumber = scanner.next();
                    System.out.println("Enter PIN:");
                    String cardPin = scanner.next();
                    Account acc = findAccount(cardNumber,cardPin);
                    if (acc != null) {
                        cardMenu(acc);
                    } else {
                        System.out.println("Wrong input!");
                    }
                    break;
                case 3:
                    choice = 0;
                    break;
                default:
                    System.out.println("Wrong input!");


            }
        }


    }

    static void printCardAndPin(Account account) {
        System.out.println("Vas broj kartice: " + account.getCardNumber());
        System.out.println("Vas PIN:" + account.getCardPin());
    }

    static Account findAccount(String cardNumber, String cardPIN) {
        for (int i = 0; i < accounts.size(); i++) {
            if (cardNumber.equals(accounts.get(i).getCardNumber()) && cardPIN.equals(accounts.get(i).getCardPin())) {
                return accounts.get(i);
            }
        }
        return  null;



    }

    static void cardMenu(Account account) {

        System.out.println("You have successfully logged in!");
        boolean isActive = true;
        while (isActive) {
            System.out.println("1. Balance\n2.Log out \n3.Exit");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println(account.getBalance());
                    break;
                case 2:
                    isActive = false;
                    System.out.println("You have successfully logged out!");
                    break;
                case 3:
                    System.exit(0);
            }
        }

    }


}
