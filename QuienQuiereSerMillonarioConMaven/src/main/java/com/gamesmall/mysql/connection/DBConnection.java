package com.gamesmall.mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String url = "jdbc:mysql://localhost:3307/millonariodb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String pwd = "1234";

    private static Connection connection = null;

    public static Connection getInstance() throws SQLException {

        if (connection == null) {
            // https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-statements.html
            connection = DriverManager.getConnection(url, user, pwd);
        }
        return connection;

    }
}
