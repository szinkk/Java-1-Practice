import java.time.LocalDateTime;

public class CustomerAccount {
    private final String clientName;
    private int currentAmount;
    private final LocalDateTime creationTime;
    private boolean frozenStatus;

    public CustomerAccount(String clientName) {
        this.clientName = clientName;
        this.currentAmount = 0;
        this.creationTime = LocalDateTime.now();
        this.frozenStatus = false;
    }

    public boolean addFunds(int sum) {
        if (sum <= 0) {
            return false;
        }
        currentAmount += sum;
        return true;
    }

    public boolean removeFunds(int sum) {
        if (frozenStatus || sum <= 0 || sum > currentAmount) {
            return false;
        }
        currentAmount -= sum;
        return true;
    }

    public boolean sendMoney(CustomerAccount targetAccount, int sum) {
        if (frozenStatus || targetAccount == null || sum <= 0 || sum > currentAmount) {
            return false;
        }
        currentAmount -= sum;
        targetAccount.currentAmount += sum;
        return true;
    }

    // Методы доступа
    public String getClientName() {
        return clientName;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public boolean isFrozen() {
        return frozenStatus;
    }

    // Метод изменения статуса
    public void setFrozenStatus(boolean status) {
        frozenStatus = status;
    }
}