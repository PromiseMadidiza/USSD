import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class USSD implements IUSSD {
    Scanner input;
    List<Account> accounts;
    Transaction transaction;
    Account loggedAccount;

    USSD() {
        input = new Scanner(System.in);
        accounts = new ArrayList<Account>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("database.txt")));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                accounts.add(new Account(tokens[0], tokens[1], tokens[2], Double.valueOf(tokens[3])));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        transaction = new Transaction(accounts);
    }

    @Override
    public Account login() {
        System.out.print("Username: ");
        String Username = input.next();
        System.out.print("password: ");
        String password = input.next();

        // Validation
        for (Account account : accounts) {
            if (account.getUsername().equals(Username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void menu() {
        System.out.println("Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Send Money");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Exit");
        System.out.println();
        System.out.print("Enter Your Choice:");
    }

    @Override
    public void start(String ussdcode) {
        System.out.println("Welcome to G4L Bank");
        System.out.println();

        if (ussdcode.compareTo("*120*359#") == 0) {
            if ((loggedAccount = login()) != null) {
                while (loggedAccount != null) {
                    menu();
                    int Choice = input.nextInt();

                    switch (Choice) {
                        case 1:
                            System.out.println("You have R" + transaction.checkBalance(loggedAccount) + " in your account");
                            break;
                        case 2:
                            transaction.sendMoney(loggedAccount);
                            break;
                        case 3:
                            transaction.deposit(loggedAccount);
                            break;
                        case 4:
                            transaction.Withdraw(loggedAccount);
                            break;
                        case 5:
                            loggedAccount = null;
                    }

                }
            } else {
                System.out.println("Invalid Login...");
            }
        }

    }

}
