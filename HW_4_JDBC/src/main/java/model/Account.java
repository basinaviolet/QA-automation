package model;

public class Account {
    public enum Currency {
        BYN, EUR, USD, RUB
    }

    private int accountId;
    private int userId;
    private int balance;
    private Currency currency;

    public Account(int accountId, int userId, int balance, Currency currency) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
        this.currency = currency;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        if (accountId > 0 && accountId <= Integer.MAX_VALUE) {
            this.accountId = accountId;
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
       if (balance >= 0 && balance < 2000000000) {
           this.balance = balance;
       }
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
