package com.onlinebookstore.dao;

import java.util.List;

import com.onlinebookstore.pojo.Customer;

public interface CustomerDao 
{
	public boolean addCustomer(Customer c);
	public boolean updCusomer(Customer c);
	public boolean deleteCustomer(int  customerId);
	public List<Customer>getAllCustomer();
	public Customer searchByCustomerEmailId(String emailId);
	public Customer searchById(int customerId);
	
}
