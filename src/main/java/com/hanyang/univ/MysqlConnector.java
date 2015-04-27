package com.hanyang.univ;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnector {
	  
	  private String responseString;
	  private Connection connect = null;
	  private String query = null;
	  private PreparedStatement preparedStmt = null;
	  
	  public String Insertdata(String stnum, 
			  String stname, String usertoken, 
			  String provider, String dataplan, String network) throws Exception {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/",
					"root", "");
			query = "insert into Bonafide.StudentInfo (stnum, stname, usertoken, provider, dataplan, network) "
					+ "values (?,?,?,?,?,?)"
					+ "ON DUPLICATE KEY UPDATE stname=?, usertoken=?, provider=?, dataplan=?, network=?";

			preparedStmt = connect.prepareStatement(query);
			preparedStmt.setString(1, stnum);
			preparedStmt.setString(2, stname);
			preparedStmt.setString(3, usertoken);
			preparedStmt.setString(4, provider);
			preparedStmt.setString(5, dataplan);
			preparedStmt.setString(6, network);
			preparedStmt.setString(7, stname);
			preparedStmt.setString(8, usertoken);
			preparedStmt.setString(9, provider);
			preparedStmt.setString(10, dataplan);
			preparedStmt.setString(11, network);
			
			preparedStmt.executeUpdate();
			
			connect.close();
			responseString = "Assignment submission is done";
			
			} 
		
		catch (SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
			responseString = "Check data you have entered";
		}
		return responseString;
	}
}
