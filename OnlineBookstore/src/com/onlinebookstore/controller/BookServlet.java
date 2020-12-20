 package com.onlinebookstore.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.onlinebookstore.dao.BookDao;
import com.onlinebookstore.dao.BookDaoImpl;
import com.onlinebookstore.dao.CartDao;
import com.onlinebookstore.dao.CartDaoImpl;
import com.onlinebookstore.pojo.Book;
import com.onlinebookstore.pojo.Cart;
@MultipartConfig(maxFileSize =16777215)
/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Book book=new Book();
	BookDao bookdao=new BookDaoImpl();
	Cart cart=new Cart();
	CartDao cartdao=new CartDaoImpl();
     
    public BookServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String operation=request.getParameter("action");
		if(operation!=null&& operation.equals("delete"))
		{
			int bookId=Integer.parseInt(request.getParameter("id"));
			book.setBookId(bookId);
			boolean b=bookdao.deleteBook(bookId);
			if(b)
		    {
				/*
				 * RequestDispatcher rd=request.getRequestDispatcher("BookServlet");
				 * rd.forward(request, response);
				 */
				
				response.sendRedirect("BookServlet");
		    	
		    }
		    else
		    {
		    	RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
		    	
		    	
		    }
		}
		else if(operation!=null&& operation.equals("edit"))
		{
			int bookId=Integer.parseInt(request.getParameter("id"));
			book.setBookId(bookId);
			book=bookdao.searchById(bookId);
			session.setAttribute("bookId", book);
			response.sendRedirect("updateBook.jsp");
		} 
		
		else if(operation!=null&& operation.equals("SearchByCategory"))
		{
			String bookcategory=request.getParameter("category");
			
			List<Book> categoryList=bookdao.searchByCategory(bookcategory);
			session.setAttribute("Book", categoryList);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
		    requestDispatcher.forward(request, response);
		
		} 
		else if(operation!=null&& operation.equals("SearchByPublisher"))
		{
			String bookpublisher=request.getParameter("publisher");
			
			List<Book> publisherList=bookdao.searchByPublisher(bookpublisher);
			session.setAttribute("Book", publisherList);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
		    requestDispatcher.forward(request, response);
		
		} 
		
		
		
		else if(operation!=null&& operation.equals("addtocart"))
		{
			int cartId=Integer.parseInt(request.getParameter("id"));
			cart.setCartId(cartId);;
			boolean b=cartdao.addToCart(cart);
			if(b)
		    {
				RequestDispatcher rd=request.getRequestDispatcher("BookServlet");
				rd.forward(request, response); 
		    	
		    }
		    else
		    {

		    	RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
		    	
		    }
		}
		
		
		
		
		
		else if(operation!=null&& operation.equals("SearchByCategory"))
		{
			String bookcategory=request.getParameter("category");
			
			List<Book> categoryList=bookdao.searchByCategory(bookcategory);
			
			
			
			
			session.setAttribute("Book", categoryList);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
		    requestDispatcher.forward(request, response);
		
		} 
		else if(operation!=null&& operation.equals("SearchByPublisher"))
		{
			String bookpublisher=request.getParameter("publisher");
			
			List<Book> publisherList=bookdao.searchByPublisher(bookpublisher);
			session.setAttribute("Book", publisherList);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
		    requestDispatcher.forward(request, response);
		
		} 
		
		else if(operation!=null&& operation.equals("searchByName"))
		{
			String bookName=request.getParameter("bookname");
			List<Book> bookList=bookdao.searchByName(bookName);
			Gson gson=new Gson();
			JsonElement jsonElement=gson.toJsonTree(bookList,new TypeToken<List<Book>> () {}.getType());
					
			JsonArray jsonArray=jsonElement.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			System.out.println(jsonArray);
			
			
		} 
		
		else if(operation!=null&& operation.equals("getCategory"))
		{
			List<Book> cList=bookdao.getAllCategories();
			
		
			Gson gson=new Gson();
			String cateogy=gson.toJson(cList);
					
			
			response.setContentType("application/json");
			response.getWriter().print(cateogy);
			System.out.println(cateogy);
			
			
		} 
		
		else if(operation!=null&& operation.equals("getPublisher"))
		{
			
			List<Book> pList=bookdao.getAllPublisher();
			
			Gson gson=new Gson();
			String publisher=gson.toJson(pList);
					
			
			response.setContentType("application/json");
			response.getWriter().print(publisher);
			System.out.println(publisher);
			
		} 
		
		else
			{
			List<Book> bookList=bookdao.getAllBooks();
			session.setAttribute("Book",bookList);
		    
		    
		    List<Book> categoryList=bookdao.getAllCategories();
		   
			session.setAttribute("Bookcategory",categoryList);
		    
		    
		    List<Book> publisherList=bookdao.getAllPublisher();
			session.setAttribute("Bookpublisher",publisherList);
		    
		    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String operation=request.getParameter("action");
		if(operation!=null&& operation.equals("add"))
		{
		
	   String bookName=request.getParameter("bookName");
	    double price=Double.parseDouble(request.getParameter("price"));
	    String author=request.getParameter("author");
	    String publisher=request.getParameter("publisher");
	    String bookdesc=request.getParameter("bookdesc");
	    String category=request.getParameter("category");
	    int quantity=Integer.parseInt(request.getParameter("quantity"));
		
	    
			/*
			 * Part getPart=request.getPart("bookImage"); InputStream
			 * is=getPart.getInputStream();
			 */
	    
	    Part part=request.getPart("bookImage");
	    String fileName=extractFileName(part);
	    String  savepath="/home/ctuser01/Desktop/bhagya108/BookStore_22265/WebContent/images"+File.separator+fileName;
	    File filesaveDir=new File(savepath);
	    part.write(savepath+File.separator);
	    
	    
	    book.setBookName(bookName);
	    book.setPrice(price);
	    book.setAuthor(author);
	    book.setPublisher(publisher);
	    book.setBookDesc(bookdesc);
	    book.setCategory(category);
	    book.setQuantity(quantity);
	    book.setBookImage(savepath);
	    book.setFilename(fileName);
	    boolean b=bookdao.addBook(book);
	    if(b)
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
			rd.forward(request, response);
	    	
	    	
	    }
	    else
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
	    	
	    }
	    
	    
	   }
		else if(operation!=null&& operation.equals("update"))
		{
		int bookId=Integer.parseInt(request.getParameter("bookId"));
	    String bookName=request.getParameter("bookName");
	    double price=Double.parseDouble(request.getParameter("price"));
	    String author=request.getParameter("author");
	    String publisher=request.getParameter("publisher");
	    String bookdesc=request.getParameter("bookdesc");
	    String category=request.getParameter("category");
	    int quantity=Integer.parseInt(request.getParameter("quantity"));
	   
	    
	    
	    
	    
	    book.setBookId(bookId);
	    book.setBookName(bookName);
	    book.setPrice(price);
	    book.setAuthor(author);
	    book.setPublisher(publisher);
	    book.setBookDesc(bookdesc);
	    book.setCategory(category);
	    book.setQuantity(quantity);
	    
	    boolean b=bookdao.updateBook(book);
	    if(b)
	    {
	    	response.sendRedirect("BookServlet");
				/*
				 * RequestDispatcher rd=request.getRequestDispatcher("BookServlet");
				 * rd.forward(request, response);
				 */
	    	
	    }
	    else
	    {
	    	
	    	RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response); 
	    }
	    
	    
	   }

	}

	private String extractFileName(Part part) {
		String contentDisp=part.getHeader("content-disposition");
		String[]items=contentDisp.split(";");
		for(String s:items)
		{
			if(s.trim().startsWith("filename"))
			{
				return s.substring(s.indexOf("=")+2,s.length()-1);
			}
		}
			
			
		return "";
	}}