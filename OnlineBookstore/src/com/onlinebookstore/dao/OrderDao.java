package com.onlinebookstore.dao;

import java.util.List;

import com.onlinebookstore.pojo.Order;

public interface OrderDao 
{
   public int placeOrder(String emailId);
  // public int placeOrder(String emailId,double totalBill);
   public List<Order> getAllOrder();
   public String checkorderStatus(int orderId);
   public int placeOrder(Order o);
}
