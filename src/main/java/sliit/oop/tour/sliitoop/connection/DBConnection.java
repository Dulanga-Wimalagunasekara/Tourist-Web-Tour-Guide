package sliit.oop.tour.sliitoop.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Dulanga Wimalagunasekara
 * Singleton DBConnection class returning a single JDBC connection for all usages
 * */
public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() {}

    public static DBConnection getDBConnection() {
        return dbConnection == null ? dbConnection = new DBConnection() : dbConnection;
    }

    public Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            } else {
                try {

                    Properties properties = new Properties();
                    properties.load(this.getClass().getResourceAsStream("/application.properties"));
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    return connection = DriverManager.getConnection(properties.getProperty("db.host"), properties.getProperty("db.username"),
                            properties.getProperty("db.password"));

                } catch (SQLException | IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}