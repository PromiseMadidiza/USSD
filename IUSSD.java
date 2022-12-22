public interface IUSSD {
    public Account login();
    public void menu();
    public void start(String ussdcode); // Abstract method that will start your app
}
