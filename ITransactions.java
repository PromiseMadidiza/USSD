public interface ITransactions {
    public void sendMoney(Account logged);
    public void deposit();
    public void Withdraw();
    public double checkBalance(Account logged);
}
