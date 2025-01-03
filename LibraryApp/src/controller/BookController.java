package controller;

import dao.BookDAO;
import model.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookController {
	
	private BookDAO bookDAO;
	
	public BookController(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public void addBook(String title, String author, Boolean available) {
		try {
			Book book = new Book(0, title, author, available);
			bookDAO.addBook(book);
		} catch (SQLException e) {
			System.err.println("Error adding book: " + e.getMessage());
		}
	}
	
	public void updateBook(int id, String title, String author, Boolean available) {
		try {
			Book book = new Book(id, title, author, available);
			bookDAO.updateBook(book);
		} catch (SQLException e) {
			System.err.println("Error updating book: " + e.getMessage());
		}
	}
	
	public void deleteBook(int id) {
		try {
			bookDAO.deleteBook(id);
		} catch (SQLException e) {
			System.out.println("Error deleting book: " + e.getMessage());
		}
	}
	
	public void listBooks() {
		try {
			List<Book> books = bookDAO.getAllBooks();
			books.forEach(System.out::println);
		} catch (SQLException e) {
			System.out.println("Error listening books: " + e.getMessage());
		}
	}
	
}