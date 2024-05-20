//Database Connection class to connect QuizApplication to mySQL database
package QuizApplication;

import java.sql.*;

public class DatabaseConnection {

    public static Connection getCon() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "Oxalicacid.1");

            return con;

        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }

    }

}
