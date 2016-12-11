package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BookDAO;
import model.dto.BookDTO;

public class UpdateBookController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String author = req.getParameter("author");
		String image = req.getParameter("image");
		
		BookDTO book = new BookDTO();
		book.setId(id);
		book.setTitle(title);
		book.setDescription(description);
		book.setAuthor(author);
		book.setImage(image);
		
		if(BookDAO.bookInstance.update(book)){
			System.out.println("Update Successfully!");
		}else{
			System.out.println("Update Failed!");
		}
		resp.sendRedirect(req.getContextPath() + "/admin/books");
	}
	
}
