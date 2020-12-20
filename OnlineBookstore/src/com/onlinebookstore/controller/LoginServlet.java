package com.onlinebookstore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.onlinebookstore.dao.LoginDao;
import com.onlinebookstore.dao.LoginDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       LoginDao logindao=new LoginDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
	   RequestDispatcher requstDispatcher=request.getRequestDispatcher("Home.jsp");
	requstDispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		String type=request.getParameter("type");
		String operation=request.getParameter("action");
	       HttpSession session=request.getSession();

		if(operation!=null&& operation.equals("login"))
		{
			
			if(type.equals("admin"))
			{
				boolean b=logindao.adminLogin(emailId, password);
				if(b)
			    {
					session.setAttribute("adminId",emailId);
			    	//response.sendRedirect("Success.jsp");

			    	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response); 
			    }
			    else
			    {

			    	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					rd.forward(request, response); 
			    	
			    }
			    
			}
			else if(type.equals("user"))
			{
				boolean b=logindao.customerLogin(emailId, password);
				if(b)
			    {
					session.setAttribute("customerId",emailId);
			    	//response.sendRedirect("Success.jsp");
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response); 
			    }
			    else
			    {
			    	
			    	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					rd.forward(request, response); 
			    	
			    }
			    
			}
			
			}
		
		else if(operation.equals("changepassword"))
		{
			boolean flag=logindao.adminLogin(emailId, password);
			System.out.println("flag"+flag+"user"+emailId+"pass"+password);
			if(flag)
			{
				String newpassword=request.getParameter("newpassword");
				String confirmpassword=request.getParameter("newpassword");
				if(confirmpassword.equals(newpassword))
				{
					flag=logindao.changePassword(emailId, newpassword);
					
				
				if(flag)
				{
					
					RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
					rd.forward(request, response); 
				}
				
				else
				{
					System.out.println("Password does not match");
					RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response); 
				}
				}
			}
			else
			{System.out.println("Incoorct username and passowrd");
			RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response); ;
			}
			
			
			
			
		}
	}

}
