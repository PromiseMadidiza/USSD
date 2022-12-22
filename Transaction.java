import java.util.List;
import java.util.Scanner;

public class Transaction implements ITransactions {
    List<Account> accounts;
    Scanner input;

    Transaction(List<Account> accounts) {
        this.accounts = accounts;
        this.input = new Scanner(System.in);
    }

    @Override
    public void sendMoney(Account logged) {
        System.out.println("Who are you sending money to: ");
        String account = input.next();

        System.out.println("How much: ");
        Double amount = input.nextDouble();

        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(account)) {
                logged.setBalance(logged.getBalance() - amount);
                acc.setBalance(acc.getBalance() + amount);
                break;
            }
        }
    }

    @Override
    public double checkBalance(Account logged) {
        return logged.getBalance();
    }

    @Override
    public void deposit(Account logged) {
        System.out.println("Your balance is " + logged.getBalance());
        System.out.println("How much are you depositing: ");
        Double amount = input.nextDouble();
    }

    @Override
    public void Withdraw() {

    }

}
