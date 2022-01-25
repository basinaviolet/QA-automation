package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    public Connection JDBCGetConnection() throws SQLException {
        final String dbPath = System.getProperty("user.dir") + "/src/main/resources/usersAccountDB.db";
        String connectionUri = "jdbc:sqlite:" + dbPath;

        Connection connection = DriverManager.getConnection(connectionUri);
        return connection;
    }

    public void JDBCCloseConnection(Connection connection) throws SQLException {
        if(connection != null){
            connection.close();
        }
    }

}
