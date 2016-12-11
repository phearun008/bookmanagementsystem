package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;
import model.dto.User;

public class ActionLogin extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = UserDAO.userInstance.login(username, password);
		
		if(user != null){
			System.out.println("User logined!");
			
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			
			System.out.println("Set session successfully!");	
			resp.sendRedirect(req.getContextPath() + "/admin/books");
			
		}else{
			System.out.println("Login failed!");
			resp.sendRedirect(req.getContextPath() + "/login");
		}		
	}
	
	
}
