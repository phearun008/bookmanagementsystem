package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.BookDAO;
import model.dto.BookDTO;

public class FindAllBooksController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BookDAO bookDAO = BookDAO.bookInstance; // singleton pattern
		// BookDAO bookDAO = new BookDAO();

		ArrayList<BookDTO> books = bookDAO.findAllBooks();

		req.setAttribute("books", books);
		req.getRequestDispatcher("/view/index.jsp").forward(req, resp);

	}

}
