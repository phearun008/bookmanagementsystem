package model.dao;

import model.dto.User;

public class UserDAO {
	
	public static UserDAO userInstance = new UserDAO(); 
	
	private UserDAO(){
		System.out.println("Constructor...!");
	}
	
	public User login(String username, String password){
		
		return null;
	}
	
}
