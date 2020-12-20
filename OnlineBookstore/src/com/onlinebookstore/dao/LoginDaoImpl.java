package com.onlinebookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinebookstore.utility.DBUtility;

public class LoginDaoImpl implements LoginDao
{
	Connection conn = null;
	PreparedStatement ps = null;

	@Override
	public boolean customerLogin(String emailId, String password)
	{
		
		try 
		{
			conn = DBUtility.getConnect();
			String sql = "select*from Customer_22265 where emailId=?  and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,emailId);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} 
		catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean adminLogin(String emailId, String password)
	{
		try 
		{
			conn = DBUtility.getConnect();
			String sql = "select*from admin where email=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,emailId);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} 
		catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean changePassword(String emailId, String newpassword) 
	{
		try 
		{
			conn = DBUtility.getConnect();
			String sql = "update admin set password=? where email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,newpassword);
			ps.setString(2,emailId);
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
		catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		return false;
	}

}
