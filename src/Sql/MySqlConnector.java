package Sql;

import Sql.model.MyProductModel;

import java.sql.*;

public class MySqlConnector {
    private static final String DATABASE_URL = "jdbc:mysql://localhost/firstschema";
    private static final String USER = "root";
    private static final String PASSWORD = "kik14051990";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class.forName(JDBC_DRIVER).newInstance();
        try (Connection firstConnection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            System.out.println("Connection successful");
            getProduct(firstConnection);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }

    private static void getProduct(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
            MyProductModel product = convert(resultSet);
            System.out.println(product);
            printData(resultSet);
        }
    }   

    private static void printData(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int price = resultSet.getInt(3);
            int quantity = resultSet.getInt(4);
            System.out.println(id + " " + name + " " + price + " " + quantity);
        }

    }


    private static MyProductModel convert(ResultSet resultSet) {
        MyProductModel product = new MyProductModel();
        return product;
    }
}