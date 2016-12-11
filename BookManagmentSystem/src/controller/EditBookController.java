package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BookDAO;
import model.dto.BookDTO;

public class EditBookController extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		BookDTO book = BookDAO.bookInstance.findBook(id);
		
		req.setAttribute("book", book);
		
		req.getRequestDispatcher("/view/save.jsp")
		   .forward(req, resp);
	}
	
}












