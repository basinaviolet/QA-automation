package tableQueries;

import sqlRequests.SqlQueries;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public boolean sqlCreateTable(String identifier, Statement statement) {
        String query = SqlQueries.getQuery("create", identifier);
        try {
            statement.execute(query);
            return true;
        }
        catch (SQLException e){
            System.out.println(identifier + ": Creating table failed");
            e.printStackTrace();
            return false;
        }
    }
}
