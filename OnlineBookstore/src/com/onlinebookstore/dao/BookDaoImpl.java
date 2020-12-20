package com.onlinebookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookstore.pojo.Book;
import com.onlinebookstore.utility.DBUtility;

public class BookDaoImpl implements BookDao {
	Connection conn = null;
	PreparedStatement ps = null;

	@Override
	public boolean addBook(Book b) {
		try {
			conn = DBUtility.getConnect();
			String sql = "insert into Book_22265(bookName,price,author,publisher,bookDesc,category,quantity,bookImage,filename)values(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setDouble(2, b.getPrice());
			ps.setString(3, b.getAuthor());
			ps.setString(4, b.getPublisher());
			ps.setString(5, b.getBookDesc());
			ps.setString(6, b.getCategory());
			ps.setInt(7, b.getQuantity());
			ps.setString(8, b.getBookImage());
			ps.setString(9,b.getFilename());
			
			
		int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBook(Book b) {
		try {
			conn = DBUtility.getConnect();
			String sql = "update Book_22265 set bookName=?,price=?,author=?,publisher=?,bookDesc=?,category=?,quantity=? where bookId=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setDouble(2, b.getPrice());
			ps.setString(3, b.getAuthor());
			ps.setString(4, b.getPublisher());
			ps.setString(5, b.getBookDesc());
			ps.setString(6, b.getCategory());
			ps.setInt(7, b.getQuantity());
			ps.setInt(8, b.getBookId());
			
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBook(int id) {
		try {
			conn = DBUtility.getConnect();
			String sql = "delete from Book_22265  where bookId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Book> getAllBooks() {
		try {

			conn = DBUtility.getConnect();
			String sql = "select * from Book_22265 ";
			List<Book> bookList = new ArrayList<Book>();
			ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setPrice(rs.getDouble("price"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setBookDesc(rs.getString("bookDesc"));
				b.setQuantity(rs.getInt("quantity"));
				b.setCategory(rs.getString("category"));
				b.setBookImage(rs.getString("bookImage"));
				b.setFilename(rs.getString("filename"));
				
				
				
				
				bookList.add(b);

			}
			return bookList;
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Book> searchByName(String name) {
		try {
			conn = DBUtility.getConnect();
			String sql = "select * from Book_22265 where bookName=?";
			List<Book> bookList = new ArrayList<Book>();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setPrice(rs.getDouble("price"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setBookDesc(rs.getString("bookDesc"));
				b.setQuantity(rs.getInt("quantity"));
				b.setCategory(rs.getString("category"));
				bookList.add(b);

			}
			return bookList;
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Book> searchByAuthor(String Author) {
		try {
			conn = DBUtility.getConnect();
			String sql = "select * from Book_22265 where author=?";
			List<Book> bookList = new ArrayList<Book>();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Author);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setPrice(rs.getDouble("price"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
                b.setBookDesc(rs.getString("bookDesc"));
				b.setQuantity(rs.getInt("quantity"));
				b.setCategory(rs.getString("category"));
				bookList.add(b);

			}
			return bookList;
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Book> searchByPublisher(String publisher) {
		try {
			conn = DBUtility.getConnect();
			String sql = "select * from Book_22265 where publisher=?";
			List<Book> bookList = new ArrayList<Book>();
			ps = conn.prepareStatement(sql);
			ps.setString(1, publisher);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setPrice(rs.getDouble("price"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setBookDesc(rs.getString("bookDesc"));
				b.setQuantity(rs.getInt("quantity"));
				b.setBookImage(rs.getString("bookImage"));
				b.setFilename(rs.getString("filename"));
				bookList.add(b);

			}
			return bookList;
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Book> searchByCategory(String category) {
		
		try {
			conn = DBUtility.getConnect();
			String sql = "select * from Book_22265 where category=?";
			List<Book> bookList = new ArrayList<Book>();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setPrice(rs.getDouble("price"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setBookDesc(rs.getString("bookDesc"));
				b.setQuantity(rs.getInt("quantity"));
				b.setBookImage(rs.getString("bookImage"));
				b.setFilename(rs.getString("filename"));
				bookList.add(b);

			}
			return bookList;
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		
		
		return null;
	}
	@Override
	public Book searchById(int bookId) {
		try {
			conn = DBUtility.getConnect();
			String sql = "select * from Book_22265 where bookId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setPrice(rs.getDouble("price"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setBookDesc(rs.getString("bookDesc"));
				b.setQuantity(rs.getInt("quantity"));
				b.setCategory(rs.getString("category"));
				return b;

			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Book> getAllCategories() {
	
		try {

			conn = DBUtility.getConnect();
			String sql = "select DISTINCT category from Book_22265 ";
			List<Book> categoryList = new ArrayList<Book>();
			ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				
				b.setCategory(rs.getString("category"));
				categoryList.add(b);

			}
			return categoryList;
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		
		
		
		return null;
	}

	@Override
	public List<Book> getAllPublisher() {
		try {

			conn = DBUtility.getConnect();
			String sql = "select DISTINCT publisher from Book_22265 ";
			List<Book> publisherList = new ArrayList<Book>();
			ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				
				b.setPublisher(rs.getString("publisher"));
				
				publisherList.add(b);

			}
			return publisherList;
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		
		
		
		return null;
	}

	
}