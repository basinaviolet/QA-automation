package tableQueries;

import logic.ReadInsertFile;
import model.Account;
import model.Transaction;
import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FillDB {
    public void fillingDB(String identifier, Connection connection) throws SQLException {
        List<String[]> items = ReadInsertFile.readFile(identifier);
        Collection<Object> listToTable = new ArrayList<>();

            switch (identifier) {
            case "user":
                items.stream()
                        .collect(Collectors.toList())
                        .forEach(item -> listToTable.add(new User(Integer.parseInt(item[0]), item[1], item[2])));
                break;
            case "account":
                items.stream()
                        .collect(Collectors.toList())
                        .forEach(item -> listToTable.add(new Account(Integer.parseInt(item[0]), Integer.parseInt(item[1]),
                                Integer.parseInt(item[2]), Account.Currency.valueOf(item[3]))));
                break;
            case "transaction":
                items.stream()
                        .collect(Collectors.toList())
                        .forEach(item -> listToTable.add(new Transaction(Integer.parseInt(item[0]), Integer.parseInt(item[1]),
                                Integer.parseInt(item[2]))));
                break;
        }
        for (Object itemToList:listToTable) {
            InsertIntoTable.sqlInsertIntoTable(itemToList, identifier, connection);
        }
    }
}
