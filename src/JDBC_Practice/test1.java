package JDBC_Practice;



import java.sql.*;

public class test1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from student");
            while(rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
            }
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
