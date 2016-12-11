package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.BookDTO;
import ulitlity.db.BookConnection;

public class BookDAO {
	
	public static BookDAO bookInstance = new BookDAO(); 

	private BookDAO(){
		System.out.println("Constructor...!");
	}
	
	public ArrayList<BookDTO> findAllBooks(){
		//Step 1 & Step 2
		Connection con = BookConnection.getConnection();
		ArrayList<BookDTO> books = new ArrayList<>();
		try{
			//Step 3- Create statement
			String sql = "SELECT id, title, description, author, image FROM book ORDER BY id desc";
			PreparedStatement p = con.prepareStatement(sql);
			
			//Step 4- Execute query statement
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				BookDTO book = new BookDTO();
				book.setId( rs.getInt("id") );
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setDescription(rs.getString("description"));
				book.setImage(rs.getString("image"));
				
				books.add(book);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				//Step 5- Close connection
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return books;
	}
	
	public boolean save(BookDTO book){
		//Step 1 & Step 2
		Connection con = BookConnection.getConnection();
		try{
			//3- Create statement
			String sql = "INSERT INTO book(title, description, author, image) VALUES(?,?,?,?)";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, book.getTitle());
			p.setString(2, book.getDescription());
			p.setString(3, book.getAuthor());
			p.setString(4, book.getImage());
			
			//4- Execute query statement
			if(p.executeUpdate() > 0)
				return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				//Step 5- Close connection
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return false;
	}
	
	public boolean update(BookDTO book){
		
		return false;
	}
	
	public BookDTO findBook(String id) {
		
		return null;
	}
	
	public boolean remove(String id){
		
		return false;
	}
	
	
	public static void main(String[] args) throws SQLException {
		BookDTO book = new BookDTO();
		book.setTitle("test title1");
		book.setDescription("test description");
		book.setAuthor("test author");
		book.setImage("testimage");
		
		if(BookDAO.bookInstance.save(book)){
			System.out.println("save successfully!");
		}
	
		ArrayList<BookDTO> books = BookDAO.bookInstance.findAllBooks();
		System.out.println(books);
	}
	
	
	
	
	
	
}
