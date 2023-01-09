public interface ITransactions {
    public void sendMoney(Account logged);
    public void deposit(Account logged);
    public void Withdraw(Account logged);
    public double checkBalance(Account logged);
}
