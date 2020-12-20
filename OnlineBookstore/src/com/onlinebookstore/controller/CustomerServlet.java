package com.onlinebookstore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookstore.dao.CustomerDao;
import com.onlinebookstore.dao.CustomerDaoImpl;
import com.onlinebookstore.pojo.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Customer customer=new Customer();
	CustomerDao customerdao=new CustomerDaoImpl();
    public CustomerServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String operation=request.getParameter("action");
		if(operation!=null&& operation.equals("delete"))
		{
			int customerId=Integer.parseInt(request.getParameter("id"));
			customer.setCustomerId(customerId);
			boolean b=customerdao.deleteCustomer(customerId);
			if(b)
		    {
		    	
		    	RequestDispatcher rd=request.getRequestDispatcher("CustomerServlet");
				rd.forward(request, response); 
		    }
		    else
		    {
		    	
		    	RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
		    	
		    }
		}
		else if(operation!=null&& operation.equals("edit"))
		{
			int customerId=Integer.parseInt(request.getParameter("id"));
			customer.setCustomerId(customerId);
			customer=customerdao.searchById(customerId);
			session.setAttribute("custId",customer);
			
			RequestDispatcher rd=request.getRequestDispatcher("updateCustomer.jsp");
			rd.forward(request, response);
		}
		
		
		
		else
		{
		List<Customer> customerList=customerdao.getAllCustomer();
		session.setAttribute("Customer",customerList);
		
		RequestDispatcher rd=request.getRequestDispatcher("customerListt.jsp");
		rd.forward(request, response);
		
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String operation=request.getParameter("action");
		if(operation!=null&& operation.equals("add"))
		{
			 String customerName=request.getParameter("customerName");
			 String mobNo=request.getParameter("mobNo");
			 String address=request.getParameter("address");
			 String emailId=request.getParameter("emailId");
			 String password=request.getParameter("password");
			
			customer.setCustomerName(customerName);
			customer.setMobNo(mobNo);
			customer.setAddress(address);
			customer.setEmailID(emailId);
			customer.setPassword(password);
			boolean c=customerdao.addCustomer(customer);
			if(c)
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
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			 String customerName=request.getParameter("customerName");
			 String mobNo=request.getParameter("mobNo");
			 String address=request.getParameter("address");
			 String emailId=request.getParameter("emailId");
			 String password=request.getParameter("password");
			customer.setCustomerId(customerId);
			customer.setCustomerName(customerName);
			customer.setMobNo(mobNo);
			customer.setAddress(address);
			customer.setEmailID(emailId);
			customer.setPassword(password);
			boolean c=customerdao.updCusomer(customer);
			if(c)
		    {

		    	RequestDispatcher rd=request.getRequestDispatcher("CustomerServlet");
				rd.forward(request, response); 
		    	
		    }
		    else
		    {

		    	RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response); 
		    	
		    }
		    
		    
		}	
			
			
	}

}
