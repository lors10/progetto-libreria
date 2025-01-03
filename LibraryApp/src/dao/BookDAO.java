package dao;

import model.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	
	// attributi
	private Connection connection;
	
	// costruttore
	public BookDAO(Connection connection) {
		this.connection = connection;
	}
	
	// CRUD
	
	// Read
	public List<Book> getAllBooks() throws SQLException {
		
		List<Book> books = new ArrayList<>();
		String query = "SELECT * FROM books";
		
		try (Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getBoolean("available")));
			}
		}
		
		return books;
	}
	
	// Create
	public void addBook(Book book) throws SQLException {
		
		String query = "INSERT INTO books (title, author, available) VALUES (?, ?, ?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setBoolean(3, book.getAvailable());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Book added succesfully");
			} else {
				System.out.println("Book not added correctly!");
			}
		}
	}
	
	// Update
	public void updateBook(Book book) throws SQLException {
		
		String query = "UPDATE books SET title = ?, author = ?, available = ? WHERE id = ?";
		
		try(PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setBoolean(3, book.getAvailable());
			stmt.setInt(4, book.getId());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Book updated succesfully");
			} else {
				System.out.println("No book found with ID: " + book.getId());
			}
		}
	}
	
	// Delete
	public void deleteBook(int bookId) throws SQLException {
		String query = "DELETE FROM books WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, bookId);
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Book deleted succesfully.");
			} else {
				System.out.println("No book found with ID: " + bookId);
			}
		}
	}
	
} 