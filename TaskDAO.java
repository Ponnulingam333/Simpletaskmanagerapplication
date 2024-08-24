package taskmanagerapplication.com;
import java.sql.*;
public class TaskDAO {
	public void addtask(TaskManager tskcls){
	try{
		String query ="Insert into TaskList values(?,?,?,?,?);";
		Connection con =DBconnection.getConnection();
		PreparedStatement pst =con.prepareStatement(query);
		pst.setInt(1, tskcls.id);
		pst.setString(2,tskcls.title);
		pst.setString(3,tskcls.description);
		pst.setString(4,tskcls.priority);
		pst.setString(5,tskcls.status);
		pst.executeUpdate();

	}
	catch(SQLException s) {
		s.printStackTrace();
	}}
	
	public void edittasktitle(String str,int id){		
  try { String query ="update TaskList set title =? where id =?";
    Connection con =DBconnection.getConnection();
	PreparedStatement pst =con.prepareStatement(query);
	pst.setString(1,str);
	pst.setInt(2, id);
	pst.executeUpdate();}
  catch(SQLException s) {
	  s.printStackTrace();
  }}
	public void edittaskdescription(String str,int id){		
		  try { String query ="update TaskList set Taskdescription =? where id =?";
		    Connection con =DBconnection.getConnection();
			PreparedStatement pst =con.prepareStatement(query);
			pst.setString(1,str);
			pst.setInt(2, id);
			pst.executeUpdate();}
		  catch(SQLException s) {
			  s.printStackTrace();
		  }}
	public void edittaskpriority(String str,int id){		
		  try { 
			String query ="update TaskList set priority =? where id =?";
		    Connection con =DBconnection.getConnection();
			PreparedStatement pst =con.prepareStatement(query);
			pst.setString(1,str);
			pst.setInt(2, id);
			pst.executeUpdate();}
		  catch(SQLException s) {
			  s.printStackTrace();
		  }}
	public void edittaskstatus(String str,int id){		
		  try { String query ="update TaskList set Taskstatus =? where id =?";
		    Connection con =DBconnection.getConnection();
			PreparedStatement pst =con.prepareStatement(query);
			pst.setString(1,str);
			pst.setInt(2, id);
			pst.executeUpdate();}
		  catch(SQLException s) {
			  s.printStackTrace();
		  }}
public void deletetask(int id) {
	try{String query ="delete from tasklist where id = "+id+";";
	Connection con =DBconnection.getConnection();
	Statement st =con.createStatement();
	st.executeUpdate(query);}
	
	catch(SQLException s) {
		//System.out.println("Error occured");
		s.printStackTrace();
	}
}
public void viewalltasks() {
	try{
		String query ="select * from TaskList";
		Connection con =DBconnection.getConnection();
		Statement st =con.createStatement();
		ResultSet rt =st.executeQuery(query);
		while(rt.next()) {
			System.out.println("--------------");
			System.out.println("Task ID: "+rt.getInt(1));
			System.out.println("Title: "+rt.getString(2));
			System.out.println("Description: "+rt.getString(3));
			System.out.println("Priority: "+rt.getString(4));
			System.out.println("Status: "+rt.getString(5));
		}
		System.out.println("--------------");
	}
	catch(SQLException s) {
		s.printStackTrace();
	}
}
	
  
 public boolean istrue(int id) {
	try { 
	String query ="select exists(select * from TaskList where id = ?);";
	 Connection con =DBconnection.getConnection();
		PreparedStatement pst =con.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rt =pst.executeQuery();
	    rt.next();
		return rt.getBoolean(1);
		}
	catch(SQLException s) {
		//System.out.println("Enter the correct id");
		s.printStackTrace();
		 return false;}}
 public void FilterTaskByPriority(String pr) {
	try { 
	//String query ="select * from TaskList order by (case priority when \"High\" then 1 when \"Medium\" then 2 when \"Low\" then 3 else 100 end);";
	String query ="select * from TaskList where priority = ?;";
		Connection con =DBconnection.getConnection();
		PreparedStatement pst =con.prepareStatement(query);
		pst.setString(1,pr);
		ResultSet rt =pst.executeQuery();
		while(rt.next()) {
			System.out.println("--------------");
			System.out.println("Task ID: "+rt.getInt(1));
			System.out.println("Title: "+rt.getString(2));
			System.out.println("Description: "+rt.getString(3));
			System.out.println("Priority: "+rt.getString(4));
			System.out.println("Status: "+rt.getString(5));
		}
		System.out.println("--------------");}
	catch(SQLException s) {
		System.out.println("Error Occured in FilterTaskByPriority method");
		s.printStackTrace();
	}
 }
 
        	 
         }
   
	

