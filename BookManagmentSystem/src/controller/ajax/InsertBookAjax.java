package controller.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.dao.BookDAO;
import model.dto.BookDTO;

@WebServlet("/admin/ajax/save")
public class InsertBookAjax extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jsonBook = req.getParameter("book");
		System.out.println("book: " + jsonBook);
		
		BookDTO book = new Gson().fromJson(jsonBook, BookDTO.class); // convert from json string to java object
		System.out.println(book.getAuthor());
		
		resp.setContentType("application/json");
		//Response response = new Response();
		if(BookDAO.bookInstance.save(book)){
			
			//response.setStatus(true);
			//response.setMessage("Save Successfully!!!");
			//resp.getWriter().write("Save Successfully!!!");
			resp.getWriter().write("{\"status\":\"true\", \"message\": \"Save Successfully!\"}");
		}else{
			//response.setStatus(false);
			//response.setMessage("Save Failed!!!");
			//resp.getWriter().write("Save Failed!!!");
			resp.getWriter().write("{\"status\":\"false\", \"message\": \"Save Failed!!!!\"}");
		}
		
		//String resposneString = new Gson().toJson(response);//convert java object to json string
		//System.out.println(resposneString);
		//resp.getWriter().write(resposneString);
		
	}
	
	
	
	
}
