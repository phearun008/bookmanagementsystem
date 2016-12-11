package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BookDAO;
import model.dto.BookDTO;

public class SaveBookController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String author = req.getParameter("author");
		String image = req.getParameter("image");
		
		BookDTO book = new BookDTO();
		book.setTitle(title);
		book.setDescription(description);
		book.setAuthor(author);
		book.setImage(image);
		
		
		BookDAO.bookInstance.save(book);
		
		req.getRequestDispatcher("/admin/books").forward(req, resp);
	}

}
