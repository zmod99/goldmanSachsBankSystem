package Simple_banking_system;

public class Account {

    private String cardNumber;

    private String cardPin;

    double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardPin() {
        return cardPin;
    }

    String createCard() {
        String cardNumber = "400000" + String.format("%010d", (long) (Math.random() * 9999999999L));
        this.cardNumber = cardNumber;
        return cardNumber;
    }

    String createPIN() {
        String cardPIN = String.format("%04d", (long) (Math.random() * 9999L));
        this.cardPin = cardPIN;
        return cardPIN;

    }
}
