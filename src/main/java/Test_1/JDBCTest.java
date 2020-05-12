package Test_1;


import java.sql.*;

/**
 * JDBC 连接过程，
 *
 * @author sunfch
 */

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "";
        String password = "";
        String username = "";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("");

            while (resultSet.next()){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
