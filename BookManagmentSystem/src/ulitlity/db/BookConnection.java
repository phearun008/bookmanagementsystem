package ulitlity.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class BookConnection {

	public static Connection getConnection(){
		try{
			// 1- register driver classname
			Class.forName("org.postgresql.Driver");

			// 2- create connection
			//TODO: heroku database info
			String url = "jdbc:postgresql://ec2-23-21-50-120.compute-1.amazonaws.com:5432/ddao5baj6s5rf3?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			String user = "poucudjkrrwoxi";
			String password = "1xTjkjNPI_9vJF_lF0yaJ-5YHE";
			
			/*
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String user = "postgres";
			String password = "123";
			*/
			
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
