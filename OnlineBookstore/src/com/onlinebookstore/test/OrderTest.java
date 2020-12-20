package com.onlinebookstore.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.onlinebookstore.dao.OrderDao;
import com.onlinebookstore.dao.OrderDaoImpl;
import com.onlinebookstore.pojo.Order;

public class OrderTest {

	public static void main(String[] args)
	{
		String emailId;
		Scanner sc=new Scanner(System.in);
		OrderDao orderdao=new OrderDaoImpl();
		while(true)
		{
		System.out.println("1.place order");
		System.out.println("2.Show all orders");
		System.out.println("3.Check status");
		System.out.println("4.exit");
		System.out.println("Enter your choice:");
		int ch=sc.nextInt();
		switch(ch) 
		{
		case 1:
		  System.out.println("Please enter email");
		  emailId=sc.next();
		  int orderId=orderdao.placeOrder(emailId);
		  System.out.println(orderId);
		  if(orderId>0)
		   {
			 System.out.println("Order placed..!!!! OrderId is::"+orderId);
		   }
		  else
		  {
			 System.out.println("Order not placed..");
		  }
		break;
		case 2:
			 List<Order>al=orderdao.getAllOrder();
		     Iterator<Order>itr=al.iterator();
		     while(itr.hasNext())
		     {
			    System.out.println(itr.next());
		     }
		 break;
		case 3:
			System.out.println("Enter Order id");
			orderId=sc.nextInt();
			String orderstatus=orderdao.checkorderStatus(orderId);
			System.out.println(orderstatus);
		 break;
		case 4:
       	  System.exit(0);
        default:
		    	 System.out.println("Invalid choice");

		
		}

		}
	}
}
