import db.JDBCConnection;
import logic.ReadRequest;
import tableQueries.CreateTable;
import tableQueries.FillDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//import db.JDBCConnection;


public class Main {

    public static void main(String[] argc) throws SQLException {
        JDBCConnection db = new JDBCConnection();
        boolean needToCreateTable = false; //true - for filling if DB is empty, else - false
        boolean needToInsertTable = false; //true - for filling if DB is empty, else - false

       // System.out.println(RequestInfoString.ACCREPLENISHMENT.getInfoString());

        try (Connection connection = db.JDBCGetConnection()){
            //for first running: creating tables
            if (needToCreateTable){
                try (Statement statement = connection.createStatement()) {
                    CreateTable createTableForDB = new CreateTable();
                    createTableForDB.sqlCreateTable("user", statement);
                    createTableForDB.sqlCreateTable("account", statement);
                    createTableForDB.sqlCreateTable("transaction", statement);
                }
                catch (SQLException e){
                    System.out.println("Create table failed");
                    e.printStackTrace();
                }
            }
            //for first running: insert data into tables
            if (needToInsertTable){
                FillDB fillDB = new FillDB();
                fillDB.fillingDB("user", connection);
                fillDB.fillingDB("account", connection);
                //    fillDB.fillingDB("transaction", statement);
            }
            ReadRequest rr = new ReadRequest();
            rr.getRequestStr(connection);
        }
        catch (SQLException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}
