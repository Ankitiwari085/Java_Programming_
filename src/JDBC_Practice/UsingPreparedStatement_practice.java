package JDBC_Practice;
import java.sql.*;
public class UsingPreparedStatement_practice {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
             PreparedStatement statement = connection.prepareStatement("insert into student values(?,?,?)");
             statement.setInt(1,5);
             statement.setString(2,"Pratik");
             statement.setInt(3,20);
             int count =statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
