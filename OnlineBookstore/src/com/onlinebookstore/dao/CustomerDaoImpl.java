package com.onlinebookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookstore.pojo.Book;
import com.onlinebookstore.pojo.Customer;
import com.onlinebookstore.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao
{
	Connection conn=null;
	PreparedStatement ps=null;

	@Override
	public boolean addCustomer(Customer c)
	{
		try 
		{
		conn=DBUtility.getConnect();
		String sql="insert into Customer_22265(customerName,mobNo,address,emailId,password)values(?,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1, c.getCustomerName());
		ps.setString(2, c.getMobNo());
		ps.setString(3, c.getAddress());
		ps.setString(4, c.getEmailID());
		ps.setString(5, c.getPassword());
		int i=ps.executeUpdate();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	     } 
		catch (Exception e) 
		{
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public boolean updCusomer(Customer c)
	{
		try 
		{
		conn=DBUtility.getConnect();
		String sql="update Customer_22265 set customerName=?,mobNo=?,address=?,emailId=?,password=? where customerId=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, c.getCustomerName());
		ps.setString(2, c.getMobNo());
		ps.setString(3, c.getAddress());
		ps.setString(4, c.getEmailID());
		ps.setString(5, c.getPassword());
		ps.setInt(6, c.getCustomerId());
		int i=ps.executeUpdate();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	     } 
		catch (Exception e) 
		{
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId)
	{
		try 
		{
		conn=DBUtility.getConnect();
		String sql="delete from Customer_22265 where customerId=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, customerId);
		int i=ps.executeUpdate();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	     } 
		catch (Exception e) 
		{
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public List<Customer> getAllCustomer() 
	{
		
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Customer_22265";
			List<Customer> customerList=new ArrayList<>();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
			   Customer c=new Customer();
			   c.setCustomerId(rs.getInt("customerId"));
			   c.setCustomerName(rs.getString("customerName"));
			   c.setAddress(rs.getString("address"));
			   c.setEmailID(rs.getString("emailId"));
			   c.setMobNo(rs.getString("mobNo"));
			   c.setPassword(rs.getString("password"));
			   customerList.add(c);
			}
			
			return customerList;
		} 
		
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Customer searchByCustomerEmailId(String emailId)
	{
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Customer_22265 where emailId=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, emailId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				 Customer c=new Customer();
				   c.setCustomerId(rs.getInt("customerId"));
				   c.setCustomerName(rs.getString("customerName"));
				   c.setAddress(rs.getString("address"));
				   c.setEmailID(rs.getString("emailId"));
				   c.setMobNo(rs.getString("mobNo"));
				   c.setPassword(rs.getString("password"));
				  
				return c;
				
				}
			
		} 
		
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer searchById(int customerId)
	{
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Customer_22265 where customerId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				 Customer c=new Customer();
				   c.setCustomerId(rs.getInt("customerId"));
				   c.setCustomerName(rs.getString("customerName"));
				   c.setAddress(rs.getString("address"));
				   c.setEmailID(rs.getString("emailId"));
				   c.setMobNo(rs.getString("mobNo"));
				   c.setPassword(rs.getString("password"));
				  
				return c;
				
				}
			
		} 
		
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return null;
	}

	
	

	
   
}
