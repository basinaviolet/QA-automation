package logic;

import DAO.ScannerRequest;
import model.Account;
import model.Transaction;
import model.User;
import tableQueries.GetFromTable;
import tableQueries.InsertIntoTable;

import java.sql.*;
import java.util.*;

public class ReadRequest {
    private static final String STR_SEPARATOR = ";";
    private static final String ITEM_SEPARATOR = "=";
    private static final GetFromTable getSql = new GetFromTable();

    /* the first step: getting request identification
     *
     */
    public void getRequestStr(Connection connection) throws SQLException {
        String request = ScannerRequest.getScannerRequest();
        madeRequest(request, connection);
    }

    /* the second step: checking the request line and getting Map with data for SQL request,
     * depending on the request type
     */
    public static boolean madeRequest(String request, Connection connection) throws SQLException {
        System.out.println("request: " + request);
        boolean result = false;

        String[] requestArray = request.split(STR_SEPARATOR);
        Map<String, String> items = new HashMap<>();
        items.put("type", requestArray[0]);
        for (int i = 1; i < requestArray.length; i++) {
            items.put(requestArray[i].split(ITEM_SEPARATOR)[0].trim(), requestArray[i].split(ITEM_SEPARATOR)[1].trim());
        }
        String type = items.get("type").trim();
        switch (type) {
            case ("1"):
                if (!registrationRequest(items, connection)) {
                    System.out.println("Registration of new user is failed");
                } else {
                    result = true;
                }

                break;
            case ("2"):
                if (!newAccountRequest(items, connection)) {
                    System.out.println("Registration of new account is failed");
                    return false;
                } else {
                    result = true;
                }
                break;
            case ("3"):
            case ("4"):
                if (!transactionRequest(type, items, connection)) {
                    System.out.println("Transaction is failed");
                    return false;
                } else {
                    result = true;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + items.get("type"));
        }
        return result;
    }

    /* the third step: getting Map with data for SQL request. type 1 - registration new user
     * error - if the name field is missing (address - can de missing)
     */
    public static boolean registrationRequest(Map<String, String> items, Connection connection) throws SQLException {
        String user = "";
        String address = "";
        User newUser;

        for (String key : items.keySet()) {
            if ((key.compareTo("name") == 0) && items.get(key).compareTo("") != 0) {
                user = items.get(key).trim();
            }
            if (key.compareTo("address") == 0) {
                address = items.get(key).trim();
            }
        }

        if (!user.equals("")) {
            if (!checkExisting(user, address, "user", connection)) {
                newUser = new User(getNewId("user", connection), user, address);
                if (InsertIntoTable.sqlInsertIntoTable(newUser, "user", connection)) {
                    System.out.println("Registration - ok");
                    return true;
                } else {
                    return false;
                }
            } else {
                System.out.println("Registration failed, a user with this name and address exists");
                return false;
            }
        } else {
            return false;
        }
    }

    /* the third step: getting Map with data for SQL request. type 2 - new account
     * error - if a one or more fields are missing
     */
    public static boolean newAccountRequest(Map<String, String> items, Connection connection) throws SQLException {
        String userId = "";
        String currency = "";
        Account newAcc;
        for (String key : items.keySet()) {
            switch (key.trim()) {
                case ("currency"):
                    if (items.get(key).compareTo("") != 0) {
                        // if currency exists and matches valid
                        currency = (checkCurrency(items.get(key).trim())) ? items.get(key).trim() : "";
                    }
                    break;
                case ("userId"):
                    if (items.get(key).compareTo("") != 0) {
                        userId = (checkInt(key, items.get(key).trim())) ? items.get(key).trim() : "";
                    }
                    break;
            }
        }
        if ((!currency.equals("")) && (!userId.equals(""))) {
            if (!checkExisting(userId, currency, "account", connection)) {
                newAcc = new Account(getNewId("account", connection),
                        Integer.parseInt(userId),
                        0,
                        Account.Currency.valueOf(currency));
                if (InsertIntoTable.sqlInsertIntoTable(newAcc, "account", connection)) {
                    System.out.println("Creating new account - ok");
                    return true;
                } else {
                    return false;
                }
            } else {
                System.out.println("Creating of new account failed, a user with this id and type of currency exists");
                return false;
            }
        } else {
            return false;
        }
    }

    /* the third step: getting Map with data for SQL request. type 3 and 4 - new transaction
     * type 3 - addition (+), type 4 - withdrawing (-)
     * error - if a one or more fields are missing
     */
    public static boolean transactionRequest(String type, Map<String, String> items, Connection connection) throws SQLException {
        int accountId = -1;
        String amount = "";
        String currency = "";
        int userId = -1;
        Transaction newTr;

        for (String key : items.keySet()) {
            switch (key.trim()) {
                case ("accountId"):
                    if (items.get(key).compareTo("") != 0) {
                        accountId = (checkInt(key, items.get(key).trim())) ? Integer.parseInt(items.get(key).trim()) : -1;
                    }
                    break;
                case ("amount"):
                    if (items.get(key).compareTo("") != 0) {
                        // if currency exists and matches valid
                        amount = (checkInt(key, items.get(key).trim())) ? items.get(key).trim() : "";
                        if (!amount.equals("") && type.compareTo("4") == 0) {
                            amount = "-" + amount;
                        }
                    }
                    break;
                case ("currency"):
                    if (items.get(key).compareTo("") != 0) {
                        // if currency exists and matches valid
                        currency = (checkCurrency(items.get(key).trim())) ? items.get(key).trim() : "";
                    }
                    break;
                case ("userId"):
                    if (items.get(key).compareTo("") != 0) {
                        userId = (checkInt(key, items.get(key).trim())) ? Integer.parseInt(items.get(key).trim()) : -1;
                    }
                    break;
            }
        }
        if (!amount.equals("")) {
            if (accountId < 0) {
                if (userId > 0 && !currency.equals("")) {
                    accountId = getAccountId(userId, currency, connection);
                    if (accountId < 0) {
                        System.out.println("Transaction request error: invalid request, one or more fields are missing");
                        return false;
                    }
                }
            }

            newTr = new Transaction(getNewId("transaction", connection),
                    accountId,
                    Integer.parseInt(amount));
            if (InsertIntoTable.sqlInsertIntoTable(newTr, "transaction", connection)) {
                if (InsertIntoTable.sqlSetBalance(accountId, Integer.parseInt(amount), connection)) {
                    System.out.println("transaction - ok");
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /* checking value whether it is an integer
     *
     */
    public static boolean checkInt(String key, String ifItemInt) {
        try {
            Integer.parseInt(ifItemInt);
            return true;
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println(key + ": item not int");
            return false;
        }
    }

    /* checking currency whether it matches the valid one
     *
     */
    public static boolean checkCurrency(String currency) {
        Account.Currency[] currencies = Account.Currency.values();
        boolean result = false;
        for (Account.Currency c : currencies) {
            if (c.toString().compareTo(currency) == 0) {
                result = true;
            }
        }
        return result;
    }

    /* checking whether a user or an account exists
     *
     */
    public static boolean checkExisting(String item1, String item2, String identifier, Connection connection){
        Map<String, String> checkedUser = new HashMap<>();
        switch (identifier) {
            case ("user"):
                checkedUser.put("name", item1);
                checkedUser.put("address", item2);
                break;
            case ("account"):
                checkedUser.put("userId", item1);
                checkedUser.put("currency", item2);
                break;
        }
        return (getSql.sqlGetId("getId", identifier, checkedUser, connection) > 0);
    }

    /* creating a new Id by getting list of Ids and add 1
     *
     */
    public static int getNewId(String identifier, Connection connection) {
        return getSql.sqlGetLastId(identifier, connection) + 1;
    }

    /* getting the account Id by userId and currency
     *
     */
    public static int getAccountId(int userId, String currency, Connection connection){
        Map<String, String> itemForSqlRequest = new HashMap<>();
        itemForSqlRequest.put("userId", "" + userId);
        itemForSqlRequest.put("currency", currency);
        int result = getSql.sqlGetId("getId", "account", itemForSqlRequest, connection);
        if (result > 0) {
            return result;
        } else {
            System.out.println("the account is doesn`t match with any userId");
            return 0;
        }
    }

}
