public class Account extends User {
    private String accountNumber;
    private double balance;

    Account(String un, String up,
            String acc, Double bal) {
        super(un, up);
        this.accountNumber = acc;
        this.balance = bal;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return getUsername() + ", " + getPassword() + ", " + getAccountNumber() + ", " + getBalance();
    }
}
