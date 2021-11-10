package com.bookapp.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

/*import com.mysql.cj.xdevapi.Statement;*/
/*
 * After creating table will insert details
 * using query as insert, values have to insert using Placeholders,using try-catch calling methods as getTitle....execute the statemnt
 * delete query use in try-catch,use setInt() 
 * update  query
 * finally get all books details using ResultSet
*/
public class BookImpl implements BookInter {

	String insertQuery = "insert into book values(?,?,?,?,?)";
	String updateBookQuery = "update book set price=? where bookid=?";
	String deleteQuery = "delete from book where bookid=?";
	String authorQuery = "select * from book where author=?";
	String categoryQuery = "select * from book where category=?";
	String getAllBooksQuery = "select * from book";

	@Override
	public void addBook(Book book) {

		Connection connection = null;
		connection = ModelDAO.openConnection();
		PreparedStatement st;
		try {
			st = connection.prepareStatement(insertQuery);
			st.setString(1, book.getTitle());
			st.setString(2, book.getAuthor());
			st.setString(3, book.getCategory());
			st.setInt(4, book.getBookid());
			st.setInt(5, book.getPrice());

			st.execute();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean deleteBook(int bookId) throws BookNotFoundException {
// TODO Auto-generated method stub
		Connection connection = null;
		connection = ModelDAO.openConnection();
		PreparedStatement st;
		try {
			st = connection.prepareStatement(deleteQuery);

			st.setInt(1, bookId);

			st.execute();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Book getBookById(int bookId) throws BookNotFoundException {
// TODO Auto-generated method stub

		return null;
	}

	@Override
	public boolean updateBook(int bookId, int price) {
// TODO Auto-generated method stub
		Connection connection = null;
		connection = ModelDAO.openConnection();
		PreparedStatement st;
		try {
			st = connection.prepareStatement(updateBookQuery);
			st.setInt(1, price);
			st.setInt(2, bookId);

			st.execute();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Book> getAllBooks() {
// TODO Auto-generated method stub

		Connection connection = null;
		connection = ModelDAO.openConnection();
		PreparedStatement st;
		try {
			st = connection.prepareStatement(getAllBooksQuery);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String title = rs.getString(1);
				String author1 = rs.getString(2);
				String category = rs.getString(3);
				int id = rs.getInt(4);
				int price = rs.getInt(5);
				System.out.println(title + "\t" + author1 + "\t" + category + "\t" + id + "\t" + price);

			}
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
// TODO Auto-generated method stub
		Connection connection = null;
		connection = ModelDAO.openConnection();
		PreparedStatement st;
		try {
			st = connection.prepareStatement(authorQuery);
			st.setString(1, author);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String title = rs.getString(1);
				String author1 = rs.getString(2);
				String category = rs.getString(3);
				int id = rs.getInt(4);
				int price = rs.getInt(5);
				System.out.println(title + "\t" + author1 + "\t" + category + "\t" + id + "\t" + price);

			}
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
// TODO Auto-generated method stub
		Connection connection = null;
		connection = ModelDAO.openConnection();
		PreparedStatement st;
		try {
			st = connection.prepareStatement(categoryQuery);
			st.setString(1, category);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String title = rs.getString(1);
				String author1 = rs.getString(2);
				String category1 = rs.getString(3);
				int id = rs.getInt(4);
				int price = rs.getInt(5);
				System.out.println(title + "\t" + author1 + "\t" + category + "\t" + id + "\t" + price);

			}
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
