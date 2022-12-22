public interface ITransactions {
    public void sendMoney(Account logged);
    public void deposit(Account logged);
    public void Withdraw();
    public double checkBalance(Account logged);
}
