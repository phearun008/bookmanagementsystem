package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BookDAO;

public class RemoveBookController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		boolean status = BookDAO.bookInstance.remove(id);
		
		if(status){
			System.out.println("Remove Successfully!");
		}
		//req.getContextPath() = http://localhost:8080/BookManagmentSystem
		resp.sendRedirect(req.getContextPath() + "/admin/books");		
	}
	
}
