package com.gamesmall.mysql.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private java.sql.Connection connection = null;

    public Connection() {

        try {

            /*
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                } catch (Exception ex) {

                }
             */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-statements.html
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/millonariodb", "root", "");
            // Statement st = connection.createStatement();
            /*
            ResultSet result = st.executeQuery("SELECT * FROM pregunta");
            while (result.next()) {
                System.out.println(result.getString("nombre"));
            }
            */

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {
            System.out.println("found exception" + e.getMessage());
        }
    }

    public java.sql.Connection getConnection() {
        return connection;
    }
}
