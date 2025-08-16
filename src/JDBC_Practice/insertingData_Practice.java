package JDBC_Practice;
import java.sql.*;

public class insertingData_Practice {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
            Statement statement = connection.createStatement();

            int count = statement.executeUpdate("insert into student values(4,'Prince',18)");

            System.out.println(count+" Rows Affected ..");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
