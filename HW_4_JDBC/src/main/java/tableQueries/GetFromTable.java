package tableQueries;

import sqlRequests.SqlQueries;

import java.sql.*;
import java.util.Map;

public class GetFromTable {

    public int sqlGetId(String action, String identifier, Map<String, String> items, Connection connection) {
        String query = SqlQueries.getQuery(action, identifier);
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            switch (identifier) {
                case ("user"):
                    preparedStatement.setString(1, items.get("name"));
                    preparedStatement.setString(2, items.get("address"));
                    break;
                case ("account"):
                    preparedStatement.setInt(1, Integer.parseInt(items.get("userId")));
                    preparedStatement.setString(2, items.get("currency"));
                break;
            }
            return preparedStatement.executeQuery().getInt(identifier + "Id");
        } catch (SQLException e) {
            System.out.println(identifier + ": getting id failed");
            e.printStackTrace();
            return -1;
        }
    }

    public int sqlGetLastId(String identifier, Connection connection) {
        String query = SqlQueries.getQuery("getLastId", identifier);
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(query).getInt("MAX(" + identifier + "Id)");
        } catch (SQLException e) {
            System.out.println(identifier + ": getting last id failed");
            e.printStackTrace();
            return -1;
        }
    }

    public static int sqlGetBalance(int accountId, Connection connection) {
        String query = SqlQueries.getQuery("getBalance", "account");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, accountId);
            return preparedStatement.executeQuery().getInt("balance");
        } catch (SQLException e) {
            System.out.println(accountId + ": getting balance failed");
            e.printStackTrace();
            return 0;
        }
    }
}
