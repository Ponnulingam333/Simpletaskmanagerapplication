package taskmanagerapplication.com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnection {
  public static Connection getConnection(){
 try { 
  String url ="jdbc:mysql://localhost:3306/TaskListdb";
  String name ="root";
  String password ="2001";
  Connection con =DriverManager.getConnection(url,name,password);
  return con;}
 catch(SQLException s) {
	 System.out.println("Please check the mysql connection");
	 return null;
 }
}}