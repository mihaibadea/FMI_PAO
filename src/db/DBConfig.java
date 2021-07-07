package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pao";

    private static final String USER = "root";

    private static final String PASSWORD = "secret";

    private static Connection databaseConnection;

    private DBConfig(){

    }

    public static Connection getDatabaseConnection(){

            try {
                if(databaseConnection==null || databaseConnection.isClosed()) {
                    databaseConnection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
                }
            }
            catch(SQLException throwables){
                throwables.printStackTrace();
            }
        return databaseConnection;
    }

    public static void closeDatabaseConnection(){

            try {
                if(databaseConnection!=null && databaseConnection.isClosed()) {
                    databaseConnection.close();
                }
            }
            catch(SQLException throwables){
                throwables.printStackTrace();
            }
        }



}
