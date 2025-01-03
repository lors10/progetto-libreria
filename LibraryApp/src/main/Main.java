package main;

import controller.BookController;
import dao.BookDAO;
import dao.DBConnection;
import view.MainView;
import java.sql.Connection;

public class Main {
	
	public static void main(String[] args) {
		try (Connection connection = DBConnection.getConnection()) {
			
			BookDAO bookDAO = new BookDAO(connection);
			BookController controller = new BookController(bookDAO);
			MainView view = new MainView(controller);
			
			view.showMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}