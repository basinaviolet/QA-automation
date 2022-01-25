package model;

public class Transaction {
    private int transactionId;
    private int accountId;
    private int amount;

    public Transaction(int transactionId, int accountId, int amount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        if (transactionId > 0 && transactionId <= Integer.MAX_VALUE) {
            this.transactionId = transactionId;
        }
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
         if (amount >= -100000000 && amount <= 100000000) {
            this.amount =  amount;
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", accountId=" + accountId +
                ", amount=" + amount +
                '}';
    }
}
