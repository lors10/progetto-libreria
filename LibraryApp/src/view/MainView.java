package view;

import controller.BookController;
import java.util.Scanner;

public class MainView {
	private BookController controller;
	
	public MainView(BookController controller) {
		this.controller = controller;
	}
	
	public void showMenu() {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("\nLibrary Menu: ");
			System.out.println("1. List Books"); // list books
			System.out.println("2. Add Book"); // add book
			System.out.println("3. Update Book"); // update book
			System.out.println("4. Delete Book"); // delete book
			System.out.println("5. Exit"); // exit
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				controller.listBooks();
				break;
			case 2:
				System.out.println("Title: ");
				String title = scanner.nextLine();
				System.out.println("Author: ");
				String author = scanner.nextLine();
				System.out.println("Available: ");
				Boolean available = scanner.nextBoolean();
				
				controller.addBook(title, author, available);
				break;
			case 3:
				System.out.print("Book ID to update: ");
			    int updateId = scanner.nextInt();
			    scanner.nextLine(); 
			    System.out.print("New Title: ");
			    String newTitle = scanner.nextLine();
			    System.out.print("New Author: ");
			    String newAuthor = scanner.nextLine();
			    System.out.print("New Available: ");
			    Boolean newAvailable = scanner.nextBoolean();
			    
			    controller.updateBook(updateId, newTitle, newAuthor, newAvailable);
			    break;
			case 4:
				System.out.print("Book ID to delete: ");
			    int deleteId = scanner.nextInt();
			    controller.deleteBook(deleteId);
			    break;
			case 5:
				System.out.println("Goodbye!");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice!");
				
			}
			
		}
	}
}