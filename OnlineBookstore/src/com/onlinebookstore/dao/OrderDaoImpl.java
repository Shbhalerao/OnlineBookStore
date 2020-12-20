package com.onlinebookstore.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.onlinebookstore.pojo.Order;
import com.onlinebookstore.utility.DBUtility;

public class OrderDaoImpl implements OrderDao
{
	Order o=new Order();
	Connection conn=null;
	PreparedStatement ps=null;
     String sql;
     ResultSet rs;int orderId;
	@Override
	public int placeOrder(String emailId)
	{
		//double totalcost=0;
		
		try 
		{//  this is for console base application
			/*conn=DBUtility.getConnect();
			String sql="select * from Book_22265 Cart as c where b.bookId=c.bookId and c.emailId=?";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setString(1, emailId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				totalcost=rs.getDouble("totalbill");
				
			}
			
			Date d= new Date();
			String today=d.toString();
			 sql="insert into bookOrder(totalbill,orderStatus,emailId,orderDate)values(?,?,?,?)";
			PreparedStatement psc=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			psc.setDouble(1, totalcost);
			psc.setString(2, "processing");
			psc.setString(3, emailId);
			psc.setString(4, today);
			int i=psc.executeUpdate();
			rs=psc.getGeneratedKeys();
			if(rs.next())
			{
				orderId=rs.getInt(1);
			}
			*/
			
			
			sql="insert into bookOrder(totalbill,orderStatus,emailId,orderDate)values(?,?,?,?)";
			PreparedStatement psc=conn.prepareStatement(sql);
			psc.setDouble(1,o.getTotalBill());
			psc.setString(2, "processing");
			psc.setString(3, emailId);
			psc.setString(4, o.getOrderDate());
			int i=psc.executeUpdate();
			rs=psc.getGeneratedKeys();
			if(rs.next())
			{
				orderId=rs.getInt(1);
			}
			
			
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
		
		return orderId;
	}

	@Override
	public List<Order> getAllOrder()
	{
		
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from bookOrder";
			List<Order> orderList=new ArrayList<Order>();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Order o=new Order();
				o.setOrderId(rs.getInt("orderId"));
				o.setEmail(rs.getString("emailId"));
				o.setOrderStatus(rs.getString("orderStatus"));
				o.setTotalBill(rs.getDouble("totalbill"));
				
				orderList.add(o);
				
			}
			return orderList;
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String checkorderStatus(int orderId) 
	{

		String status=null;
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select orderStatus from bookOrder where orderId=?";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				status=rs.getString("orderstatus");
				
			}
			
			return status;
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public int placeOrder(Order o) {
		
		try {
			conn=DBUtility.getConnect();
			sql="insert into bookOrder(totalbill,orderStatus,emailId,orderDate)values(?,?,?,?)";
			PreparedStatement psc=conn.prepareStatement(sql);
			psc.setDouble(1,o.getTotalBill());
			psc.setString(2, o.getOrderStatus());
			psc.setString(3, o.getEmail());
			psc.setString(4, o.getOrderDate());
			int i=psc.executeUpdate();
			
			if(i>0)
			{
				return 1;
			}
			
			else
			{
				return 0;
			}
		
	} 
	catch (SQLException e)
	{
		
		e.printStackTrace();
	}
	
	
		
		return 0;
	}
	

}
