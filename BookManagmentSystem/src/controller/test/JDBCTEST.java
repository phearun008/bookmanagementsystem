package controller.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTEST {

	public static void main(String[] args) throws Exception{
		
		//1- register driver classname
		Class.forName("org.postgresql.Driver");
		
		//2- create connection
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "123";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3- create statement
		String sql = "SELECT * FROM tbuser";
		PreparedStatement p = con.prepareStatement(sql);
		
		//4- execute statement query
		ResultSet rs = p.executeQuery();
		while(rs.next()){
			String id = rs.getString("id");
			String username = rs.getString("username");
			String pass = rs.getString("password");
			System.out.println(id +", "+ username + ", "+ pass);
		}
		//3- create statement
//		String sqlInsert = "INSERT INTO tbuser(id, username, password) VALUES(?,?,?)";
//		PreparedStatement p1 = con.prepareStatement(sqlInsert);
//		p1.setString(1, "b01");
//		p1.setString(2, "test");
//		p1.setString(3, "123");
//		
		//4-execute query
//		if(p1.executeUpdate()>0){
//			System.out.println("Insert Successfully!!");
//		}else{
//			System.out.println("Insert Failed!!");
//		}
		
		//5- close connection
		con.close();
		
	}
	
	
}
