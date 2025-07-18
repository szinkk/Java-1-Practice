import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        CustomerAccount account1 = new CustomerAccount("Ilya");
        account1.addFunds(1000); // баланс = 1000

        System.out.println(account1.getCurrentAmount());

        CustomerAccount account2 = new CustomerAccount("Polina");
        account1.sendMoney(account2, 500); // баланс Alice: 500, Bob: 500

        account1.setFrozenStatus(true);
        account1.removeFunds(100); // счёт заморожен

        System.out.println(account1.getClientName());
        System.out.println(account1.getCurrentAmount());
    }
}