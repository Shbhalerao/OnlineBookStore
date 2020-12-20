package com.onlinebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.onlinebookstore.dao.BookDao;
import com.onlinebookstore.dao.BookDaoImpl;
import com.onlinebookstore.pojo.Book;

/**
 * Servlet implementation class demoJsonServlet
 */


public class demoJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      BookDao bookdao=new BookDaoImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demoJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookId=Integer.parseInt(request.getParameter("countrycode"));
		System.out.println(bookId);
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		JsonObject jsonobject=new JsonObject();
		Book bookpojo=bookdao.searchById(bookId);
		JsonElement jsonelement =gson.toJsonTree(bookpojo);
		jsonobject.addProperty("success", true);
			
		jsonobject.add("countryInfo", jsonelement);	
		
		out.print(jsonobject.toString());
		out.close();
		
		System.out.println(jsonobject.toString());
		 
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
