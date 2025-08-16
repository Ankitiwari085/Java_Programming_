package JDBC_Practice;
import java.sql.*;

public class Quering_Data {
    public static void main(String[] args) {
        int age = 22;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select Name from student where age ="+age);
            resultSet.next();
            System.out.println(resultSet.getString(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// DOA :- Data Object Access is used to access the data from the dataset ... we use  while quering in the data
