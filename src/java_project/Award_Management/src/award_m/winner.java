package award_m;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class winner extends Database {
	public int Winner_id;
	public winner() {
		try {
		int low=-1;
		String Query="select vote_id,count(*) as count from login group by vote_id";
		PreparedStatement stmt=Query(Query);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			if(rs.getInt("count")>low) {
				low=rs.getInt("count");
				this.Winner_id=rs.getInt("vote_id");
				System.out.print(Winner_id);
			}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int get_winner() {
		return Winner_id;
	}
}
