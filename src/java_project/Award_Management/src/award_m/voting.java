package award_m;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;


public class voting implements Vote {
	protected Connection connection;
	public PreparedStatement stmt; 
	public PreparedStatement stmt1; 
	public PreparedStatement stmt2; 
	public String username;
	public String password;
	public int id;
	public String user;
	public String Pass;
	
	public voting(String username,String password,int id) {
		this.password=password;
		this.username=username;
		this.id=id;
	}

	@Override
	public boolean vote() {
		// TODO Auto-generated method stub
		try {
    		Class.forName("org.postgresql.Driver");
    		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Awards_", "postgres", "ssbk1830");
    	} 
    	catch (Exception e) {
	         e.printStackTrace();
	         System.err.println("Database connectivity error !");
	         System.exit(0);
	    }
		try
		{
		String Query="select * from login where username=? and password=?";
		stmt = connection.prepareStatement(Query);
		stmt.setString(1, this.username);
		stmt.setString(2, this.password);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			if(rs.getString("username")!=null) {
			String Query1="update login set vote_id = ? where username= ? and password = ?";
			stmt1 = connection.prepareStatement(Query1);
			stmt1.setInt(1, this.id);
			stmt1.setString(2, this.username);
			stmt1.setString(3, this.password);
			stmt1.execute();
			return true;
			}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
    } 

	public boolean register(String user,String Pass ,int ID) {
		try {
    		Class.forName("org.postgresql.Driver");
    		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Awards_", "postgres", "ssbk1830");
    	} 
    	catch (Exception e) {
	         e.printStackTrace();
	         System.err.println("Database connectivity error !");
	         System.exit(0);
	    }
		try {
			this.user=user;
			this.Pass=Pass;
			String Query2="insert into login(username,password,vote_id) values(?,?,?)";
			stmt2 = connection.prepareStatement(Query2);
			stmt2.setString(1, this.user);
			stmt2.setString(2, this.Pass);
			stmt2.setInt(3, ID);
			System.out.print(stmt2);
			stmt2.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
