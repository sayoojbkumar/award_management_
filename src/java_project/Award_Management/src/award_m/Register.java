package award_m;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register extends Database{
	public boolean isregistered=false;
	public String fname,lname;
	public String street,city;
	public int pin,salary,age;
	public String date,Recieved_Awards;
	
	public Register(String fname,String lname,String street,String city,int pin,int salary,String date,int age,String Recieved_Awards)
	{
		this.fname=fname;
		this.lname=lname;
		this.street=street;
		this.city=city;
		this.pin=pin;
		this.salary=salary;
		this.date=date;
		this.age=age;
		this.Recieved_Awards=Recieved_Awards;
	}
	public boolean Do_registration() {
		try 
		{
			String Query="insert into inventor(name,address,dob,age,salary,Recieved_Awards)values(( ?, ?)::name,( ?, ?, ? )::addr, ?, ?, ?, ?)";
			PreparedStatement stmt=Query(Query);
			stmt.setString(1, this.fname);
			stmt.setString(2, this.lname);
			stmt.setString(3, this.street);
			stmt.setString(4, this.city);
			stmt.setInt(5, this.pin);
			stmt.setDate(6, Date.valueOf(date));
			stmt.setInt(7, this.age);
			stmt.setInt(8, this.salary);
			stmt.setString(9, this.Recieved_Awards);
			stmt.execute(); 
			isregistered=true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return isregistered;	
	}
	public boolean add_invention(int yearofi,int budget,String story,int yearofw,String categeory) {
		int id=0,categeory_id;
		if(categeory=="Science") {
			categeory_id=1;
		}
		else if(categeory=="Technology") {
			categeory_id=2;
		}
		else if(categeory=="Mathemetics") {
			categeory_id=3;
		}
		else {
			categeory_id=4;
		}
		try
		{
		String Query1="select max(id) as id from inventor";
		String Query2="insert into invention(year_of_invention,Budget,id,story,year_of_win,category_id) values(? , ?, ?, ?, ?, ?)";
		PreparedStatement stmt1=Query(Query1);
		ResultSet rs= stmt1.executeQuery();
		while(rs.next()) {
			id=rs.getInt("id");
		}
		PreparedStatement stmt2=Query(Query2);
		stmt2.setInt(1, yearofi);
		stmt2.setInt(2, budget);
		stmt2.setInt(3, id);
		stmt2.setString(4, story);
		stmt2.setInt(5, yearofw);
		stmt2.setInt(6,categeory_id);
		System.out.print(stmt1);
		stmt2.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
}