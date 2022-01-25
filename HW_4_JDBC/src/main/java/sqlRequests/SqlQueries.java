package sqlRequests;

public enum SqlQueries {
    CREATE_USER("create", "user", "CREATE Table Users (userId integer PRIMARY KEY AUTOINCREMENT, name varchar(50) NOT NULL, address varchar(255));"),
    CREATE_ACCOUNT("create", "account", "CREATE Table Accounts(" +
            "accountId integer PRIMARY KEY AUTOINCREMENT," +
            "userId int(10) NOT NULL," +
            "balance int(10) NOT NULL check(balance >= 0 and balance < 2000000000)," +
            "currency varchar(10) NOT NULL," +
            "FOREIGN KEY(userId) REFERENCES Users (userId)" +
            ");"),
    CREATE_TRANSACTION("create", "transaction", "CREATE Table Transactions(" +
            "transactionId integer PRIMARY KEY AUTOINCREMENT," +
            "accountId int(10) NOT NULL," +
            "amount int(15) NOT NULL check(amount >= -100000000 and amount <= 100000000)," +
            "FOREIGN KEY(accountId) REFERENCES Accounts (accountId)" +
            ");"),

    INSERT_USER("insert", "user", "INSERT INTO Users (userId, name, address) VALUES (?, ?, ?);"),
    INSERT_ACCOUNT("insert", "account", "INSERT INTO Accounts (accountId, userId, balance, currency) VALUES (?, ?, ?, ?);"),
    INSERT_TRANSACTION("insert", "transaction", "INSERT INTO Transactions (transactionId, accountId, amount) VALUES (?, ?, ?);"),

    UPDATE_BALANCE("update", "account", "UPDATE Accounts SET balance = ? WHERE accountId = ?;"),

    SELECT_ALL_USERID("select", "user", "SELECT ? FROM Users ORDER BY ?;"),
    SELECT_ALL_ACCOUNTID("select", "account", "SELECT ? FROM Accounts ORDER BY ?;"),
    SELECT_ALL_TRANSACTIONID("select", "transaction", "SELECT ? FROM Transactions ORDER BY ?;"),

//    FIND_USERID("find", "user", "SELECT userId FROM Users WHERE name IN ('?') AND address IN ('?');"),
//    FIND_ACCOUNTID("find", "account", "SELECT accountId FROM Accounts WHERE userId IN (?) AND currency IN ('?');"),

    GET_USERID("getId", "user", "SELECT userId FROM Users WHERE name IN (?) AND address IN (?);"),
    GET_ACCOUNTID("getId", "account", "SELECT accountId FROM Accounts WHERE userId IN (?) AND currency IN (?);"),
    GET_BALANCE("getBalance", "account", "SELECT balance FROM Accounts WHERE accountId = ?;"),

    GET_LAST_USERID("getLastId", "user", "SELECT MAX(userId) FROM Users;"),
    GET_LAST_ACCOUNTID("getLastId", "account", "SELECT MAX(accountId) FROM Accounts;"),
    GET_LAST_TRANSACTIONID("getLastId", "transaction", "SELECT MAX(transactionId) FROM Transactions;");


    private final String action;
    private final String identifier;
    private final String query;

    SqlQueries(String action, String identifier, String query) {
        this.action = action;
        this.identifier = identifier;
        this.query = query;
    }

    public static String getQuery(String action, String identifier) {
        SqlQueries[] queryList = SqlQueries.values();
        String query = null;

        for (SqlQueries q : queryList) {
            if (q.getAction().compareTo(action) == 0 && q.getIdentifier().compareTo(identifier) == 0)
               query = q.getQuery();
        }
        return query;
    }

    public String getAction() {
        return action;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public String toString() {
        return query;
    }
}
