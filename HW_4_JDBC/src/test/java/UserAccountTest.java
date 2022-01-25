import db.JDBCConnection;
import logic.ReadRequest;
import org.testng.Assert;
import org.testng.annotations.*;
import sqlRequests.PrnResultOfQueries;

import java.sql.*;

public class UserAccountTest {
    JDBCConnection db = new JDBCConnection();
    private Connection connection = null;
    Statement statement = null;
    PrnResultOfQueries prn = new PrnResultOfQueries();

    @BeforeMethod
    public void createConnection() throws SQLException {
        connection = db.JDBCGetConnection();
        statement = connection.createStatement();
    }

    @AfterMethod
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    /*
     * Checking the function of user registration - data set for true cases
     */
    @DataProvider(name = "checkRegistrationNewUserTest")
    public static Object[][] userAssumptions(){
        return new Object[][]{{"Ivan","Minsk 1"},
                {"Ivan","Minsk 2"},
                {"Ivanna","Minsk 1"}
        };
    }

    @Test (dataProvider = "checkRegistrationNewUserTest", groups = {"insert new"})
    public void registrationNewUserTest(String name, String address) throws SQLException {
        String expect = "error";

        final String testQuery = "SELECT name, address FROM (SELECT * FROM Users ORDER BY userId DESC LIMIT 1);";
        final String testForPrintQuery = "SELECT * FROM Users ORDER BY userId DESC LIMIT 1;";
        final String request = "1; name = " + name + "; address = " + address;

        //before test
        prn.printUserResult(statement.executeQuery(testForPrintQuery));

        //request for test
        if (ReadRequest.madeRequest(request, connection)){
            expect = "name = " + name + "; address = " + address;
        }
        ResultSet resultSet = statement.executeQuery(testQuery);

        Assert.assertEquals(prn.getUserResult(resultSet), expect);

        //after test
        prn.printUserResult(statement.executeQuery(testForPrintQuery));
    }

    /*
     * Checking the function of creating new user account - data set for true cases
     */
    @DataProvider(name = "checkCreatingNewAccountTest")
    public static Object[][] accountAssumptions(){
        return new Object[][]{{"100008","BYN"},
                {"100008","USD"},
                {"100008","EUR"},
                {"100008","RUB"}
        };
    }

    @Test (dataProvider = "checkCreatingNewAccountTest", groups = {"insert new"})
    public void registrationNewAccountTest(String userId, String currency) throws SQLException {
        String expect = "error";

        final String testQuery = "SELECT userId, balance, currency FROM (SELECT * FROM Accounts ORDER BY accountId DESC LIMIT 1);";
        final String testForPrintQuery = "SELECT * FROM Accounts ORDER BY accountId DESC LIMIT 1;";
        final String request = "2; userId = " + userId + "; currency = " + currency;

        //before test
        prn.printAccountResult(statement.executeQuery(testForPrintQuery));

        //request for test
        if(ReadRequest.madeRequest(request, connection)){
            expect = "userId = " + userId + "; balance = 0; currency = " + currency;
        }
        ResultSet resultSet = statement.executeQuery(testQuery);

        Assert.assertEquals(prn.getAccountResult(resultSet), expect);

        //after test
        prn.printAccountResult(statement.executeQuery(testForPrintQuery));
    }

    /*
     * Checking the transaction function of add amount and changing account balance - data set for true cases
     * data set is similar for add and withdrawal tests
     */
    @DataProvider(name = "checkChangeAmountTest1")
    public static Object[][] amountAssumptions1(){
        return new Object[][]{{"200011", "5000"},
                {"200012", "6000"},
                {"200013", "7000"},
                {"200014", "8000"}
        };
    }

    @Test (dataProvider = "checkChangeAmountTest1", groups = {"transactions"})
    public void amountAddTest1(String accountId, String amount) throws SQLException {
        int balance;
        String expect = "error";

        final String testQuery = "SELECT accountId, balance FROM Accounts WHERE accountId =" + accountId + ";";
        final String testForPrintQuery = "SELECT * FROM Transactions WHERE accountId = " + accountId + ";";
        final String request = "3; accountId = " + accountId + "; amount = " + amount;
        final String getBalanceQuery = "SELECT balance FROM Accounts WHERE accountId = " + accountId + ";";

        //before test
        prn.printTransactionResult(statement.executeQuery(testForPrintQuery));
        balance = prn.getBalance(statement.executeQuery(getBalanceQuery));

        //request for test
        if(ReadRequest.madeRequest(request, connection)){
            expect = "accountId = " + accountId + "; balance = " + (balance + Integer.parseInt(amount));
        }
        ResultSet resultSet = statement.executeQuery(testQuery);

        Assert.assertEquals(prn.getTransactionResult1(resultSet), expect);

        //after test
        prn.printTransactionResult(statement.executeQuery(testForPrintQuery));
    }

    @Test (dataProvider = "checkChangeAmountTest1", groups = {"transactions"})
    public void amountWithdrawalTest1(String accountId, String amount) throws SQLException {
        int balance;
        String expect = "error";

        final String testQuery = "SELECT accountId, balance FROM Accounts WHERE accountId =" + accountId + ";";
        final String testForPrintQuery = "SELECT * FROM Transactions WHERE accountId = " + accountId + ";";
        final String request = "4; accountId = " + accountId + "; amount = " + amount;
        final String getBalanceQuery = "SELECT balance FROM Accounts WHERE accountId = " + accountId + ";";

        //before test
        prn.printTransactionResult(statement.executeQuery(testForPrintQuery));
        balance = prn.getBalance(statement.executeQuery(getBalanceQuery));

        //request for test
        if(ReadRequest.madeRequest(request, connection)){
            expect = "accountId = " + accountId + "; balance = " + (balance - Integer.parseInt(amount));
        }
        ResultSet resultSet = statement.executeQuery(testQuery);

        Assert.assertEquals(prn.getTransactionResult1(resultSet), expect);

        //after test
        prn.printTransactionResult(statement.executeQuery(testForPrintQuery));
    }

    @DataProvider(name = "checkChangeAmountTest2")
    public static Object[][] amountAssumptions2(){
        return new Object[][]{{"100008","BYN", "5000"},
                {"100008","USD", "6000"},
                {"100008","EUR", "7000"},
                {"100008","RUB", "8000"}
        };
    }

    @Test (dataProvider = "checkChangeAmountTest2", groups = {"transactions"})
    public void amountAddTest2(String userId, String currency, String amount) throws SQLException {
        int balance;
        String expect = "error";

        final String testQuery = "SELECT userId, currency, balance FROM Accounts WHERE userId IN (" +
                userId + ") AND currency IN ('" + currency + "');";
        final String testForPrintQuery = "SELECT * FROM Transactions WHERE accountId =" +
                "(SELECT accountId FROM Accounts WHERE " +
                "userId IN (" + userId + ") AND currency IN ('" + currency + "'));";
        final String request = "3; userId = " + userId + "; currency = " + currency + "; amount = " + amount;
        final String getBalanceQuery = "SELECT balance FROM Accounts WHERE userId IN (" +
                userId + ") AND currency IN ('" + currency + "');";

        //before test
        prn.printTransactionResult(statement.executeQuery(testForPrintQuery));
        balance = prn.getBalance(statement.executeQuery(getBalanceQuery));

        //request for test
        if(ReadRequest.madeRequest(request, connection)){
            expect = "userId = " + userId + "; currency = " + currency + "; balance = " + (balance + Integer.parseInt(amount));
        }
        ResultSet resultSet = statement.executeQuery(testQuery);

        Assert.assertEquals(prn.getTransactionResult2(resultSet), expect);

        //after test
        prn.printTransactionResult(statement.executeQuery(testForPrintQuery));
    }

    @Test (dataProvider = "checkChangeAmountTest2", groups = {"transactions"})
    public void amountWithdrawalTest2(String userId, String currency, String amount) throws SQLException {
        int balance;
        String expect = "error";

        final String testQuery = "SELECT userId, currency, balance FROM Accounts WHERE userId IN (" +
                userId + ") AND currency IN ('" + currency + "');";
        final String testForPrintQuery = "SELECT * FROM Transactions WHERE accountId =" +
                "(SELECT accountId FROM Accounts WHERE " +
                "userId IN (" + userId + ") AND currency IN ('" + currency + "'));";
        final String request = "4; userId = " + userId + "; currency = " + currency + "; amount = " + amount;
        final String getBalanceQuery = "SELECT balance FROM Accounts WHERE userId IN (" +
                userId + ") AND currency IN ('" + currency + "');";

        //before test
        prn.printTransactionResult(statement.executeQuery(testForPrintQuery));
        balance = prn.getBalance(statement.executeQuery(getBalanceQuery));

        //request for test
        if(ReadRequest.madeRequest(request, connection)){
            expect = "userId = " + userId + "; currency = " + currency + "; balance = " + (balance - Integer.parseInt(amount));
        }
        ResultSet resultSet = statement.executeQuery(testQuery);

        Assert.assertEquals(prn.getTransactionResult2(resultSet), expect);

        //after test
        prn.printTransactionResult(statement.executeQuery(testForPrintQuery));
    }
}
