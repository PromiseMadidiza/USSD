
import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        String Username;
        String password;
        
        

        try (Scanner input = new Scanner(System.in)) {
            Random rand = new Random();
            
            System.out.print("Enter Username: ");
            Username = input.next();

            System.out.print("Enter password: " );
            password= input.next();
        }
        int choice;

        System.out.println("Welcome to G4L Bank");
        System.out.println();

        System.out.println("Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Send Money");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Exit");
        System.out.println("Enter Your Choice:");

        try (Scanner sc = new Scanner(System.in)) {
            {
                choice = sc.nextInt();
            }
        }

        while (choice != 5) {
            if (choice == 1) {
                System.out.println("Check Balance");
                break;
            } else if (choice == 2) {
                System.out.println("Transfer");
                break;
            } else if (choice == 3) {
                System.out.println("Deposit");
                break;
            } else if (choice == 4) {
                System.out.println("Withdraw");
                break;
            }

        }

    }
}