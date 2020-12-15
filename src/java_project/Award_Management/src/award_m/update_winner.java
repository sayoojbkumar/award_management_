package award_m;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class update_winner extends voting {
	public update_winner(String username, String password, int id) {
		super(username, password, id);
		// TODO Auto-generated constructor stub
	}
	public boolean vote(String awards,int id) {
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
			final String isadmin=rs.getString("username");
			if(isadmin.equals("admin")); 
			{
				String Query1="update inventor set Recieved_Awards=? where id= ?";
				stmt1 = connection.prepareStatement(Query1);
				stmt1.setString(1, awards);
				stmt1.setInt(2, id);
				System.out.print(stmt1);
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
}
