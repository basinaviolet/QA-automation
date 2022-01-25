package sqlRequests;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrnResultOfQueries {
    public void printUserResult(ResultSet res) throws SQLException {
        while (res.next()){
            System.out.println("[" + "userId = " + res.getString("userId") + "; " +
                    "name = " + res.getString("name") + "; " +
                    "address = " + res.getString("address") + "]");
        }
    }

    public String getUserResult(ResultSet res) throws SQLException {
        return "name = " + res.getString("name") + "; address = " + res.getString("address");
    }

    public void printAccountResult(ResultSet res) throws SQLException {
        while (res.next()){
            System.out.println("[" + "accountId = " + res.getString("accountId") + "; " +
                    "userId = " + res.getString("userId") + "; " +
                    "balance = " + res.getString("balance") + "; " +
                    "currency = " + res.getString("currency") + "]");
        }
    }

    public String getAccountResult(ResultSet res) throws SQLException {
        return "userId = " + res.getString("userId") +
                "; balance = " + res.getString("balance") +
                "; currency = " + res.getString("currency");
    }

    public int getBalance(ResultSet res) throws SQLException {
        return res.getInt("balance");
    }

    public void printTransactionResult(ResultSet res) throws SQLException {
        while (res.next()){
            System.out.println("[" + "transactionId = " + res.getString("transactionId") + " : " +
                    "accountId = " + res.getString("accountId") + " : " +
                    "amount = " + res.getString("amount") + "]");
        }
    }

    public String getTransactionResult1(ResultSet res) throws SQLException {
        return "accountId = "+ res.getString("accountId") +
                "; balance = " + res.getString("balance");
    }

    public String getTransactionResult2(ResultSet res) throws SQLException {
        return "userId = "+ res.getString("userId") +
                "; currency = " + res.getString("currency") +
                "; balance = " + res.getString("balance");
    }
}
