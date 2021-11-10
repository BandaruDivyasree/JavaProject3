/*
 * author @Divyasree
 * version 0.1
 * */



package com.bookapp.main;
import java.sql.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.bookapp.bean.Book;
import com.bookapp.dao.BookImpl;
import com.bookapp.dao.BookInter;
import com.bookapp.dao.ModelDAO;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

/*
 * In main first have to create  Book Table
 * using while loop automatically it checks the condition and print
 * creating new book object
 * switch case using first add details of the book
 * update the price
 * delete the book
 * author name
 * category book 
 * use try-catch
 * until check is true it will continue to execute once check is false it exited  
 * 
 */

public class Client {

	public static void main(String[] args) {

		boolean check = true;
		while (check) {
			System.out.println();
			System.out.println("Welcome to Book Store");
			System.out.println("Enter Here ");
			System.out.println("1.To add book "); 
			System.out.println("2.Update a book ");
			System.out.println("3.Delete a book");
			System.out.println("4.Book by Author ");
			System.out.println("5.Book by Category");
			System.out.println("6.To get all the available books");
			System.out.println("7.Exit from the website");
			Scanner s = new Scanner(System.in);
			int num = s.nextInt();
			BookInter book = new BookImpl();
			switch (num) {
			case 1:
				System.out.println("How many books you want to add");
				int bookCount = s.nextInt();
				System.out.println("Enter the details of book title,author,category,bookId,price");
				for (int i = 0; i < bookCount; i++) {
					String title = s.next();
					String author = s.next();
					String category = s.next();
					int bookId = s.nextInt();
					int price = s.nextInt();
					Book book1 = new Book(title, author, category, bookId, price);
					book.addBook(book1);

				}
				System.out.println("Books added successfully");
				break;
			case 2:
				System.out.println("Enter bookId and price that you wants to update the price of the book");
				int bookId = s.nextInt();
				int price = s.nextInt();
				book.updateBook(bookId, price);

				System.out.println("Updated");

				break;
			case 3:
				System.out.println("Enter bookId that you wants to delete");
				int bookId1 = s.nextInt();
				try {
					book.deleteBook(bookId1);
					System.out.println("Deleted");
				} catch (BookNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Enter the author name to find book");
				String authorName = s.next();
				try {
					book.getBookbyAuthor(authorName);
				} catch (AuthorNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 5:
				System.out.println("Enter to find the category books");
				String category = s.next();
				try {
					book.getBookbycategory(category);
				} catch (CategoryNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 6:
				System.out.println("You can find everything");
				book.getAllBooks();
				break;
			case 7:
				System.out.println("Exited");
				check = false;
			default:
				System.exit(10);
				System.out.println("Exited");
			}

		}

	}

}