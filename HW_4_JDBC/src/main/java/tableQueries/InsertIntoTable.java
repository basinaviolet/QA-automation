package tableQueries;

import sqlRequests.SqlQueries;

import java.lang.reflect.Field;
import java.sql.*;

public class InsertIntoTable {

    public static boolean sqlInsertIntoTable(Object itemToInsert, String identifier, Connection connection) throws SQLException {
        String query = SqlQueries.getQuery("insert", identifier);

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            Field[] itemFields = itemToInsert.getClass().getDeclaredFields();
            int index = 0;
            for (Field f : itemFields) {
                index++;
                String type = f.getType().toString();
                f.setAccessible(true);
                switch (type) {
                    case ("int"):
                        preparedStatement.setInt(index, f.getInt(itemToInsert));
                        break;
                    case ("class java.lang.String"):
                    case ("class model.Account$Currency"):
                        preparedStatement.setString(index, f.get(itemToInsert).toString());
                        break;
                }
            }
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException | IllegalAccessException e) {
            System.out.println(identifier + ": inserting into table failed");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean sqlSetBalance(int accountId, int amount, Connection connection) throws SQLException {
        String query = SqlQueries.getQuery("update", "account");
        int newBalance =  GetFromTable.sqlGetBalance(accountId, connection) + amount;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newBalance);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(accountId + ": setting balance failed");
            e.printStackTrace();
            return false;
        }
    }
}
