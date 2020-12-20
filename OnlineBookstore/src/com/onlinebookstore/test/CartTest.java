package com.onlinebookstore.test;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.onlinebookstore.dao.CartDao;
import com.onlinebookstore.dao.CartDaoImpl;
import com.onlinebookstore.pojo.Cart;

public class CartTest {

	public static void main(String[] args)
	{
		String bookName;
		double price;
		String author,publisher,bookDesc,category,emailId;
		int bookId,bookquantity,cartId;
		Cart cart=new Cart();
		CartDao cartdao=new CartDaoImpl();
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1.Add Book To Cart");
			System.out.println("2.Show all books in Cart");
			System.out.println("3.Delete book from Cart ");
			System.out.println("4.Clear cart");
			System.out.println("5.exit");
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Add book details");
				System.out.println("Enter Book Id");
				bookId=sc.nextInt();
				System.out.println("Enter  book quantity");
				bookquantity=sc.nextInt();
				System.out.println("Enter EmailId");
				 emailId=sc.next();
				
				cart=new Cart();
				cart.setBookId(bookId);
				cart.setBookQuantity(bookquantity);
				cart.setEmailId(emailId);
				cartdao=new CartDaoImpl();
				boolean c=cartdao.addToCart(cart);
				if(c)
				{
					System.out.println("Book add to cart Successfully");
				}
				else
				{
					System.out.println("Book not added");
				}
		    break;
			case 2:
				System.out.println("Enter email id::");
				emailId=sc.next();
				List<Cart>al=cartdao.showCart(emailId);
			     Iterator<Cart>itr=al.iterator();
			     while(itr.hasNext())
			     {
				    System.out.println(itr.next());
			     }
			  break;
          case 3:
				
				System.out.println("Enter cart id to delete:");
				cartId=sc.nextInt();
				
				cart=new Cart();
				
				cart.setCartId(cartId);
				cartdao=new CartDaoImpl();
				boolean c2=cartdao.deleteFromCart(cartId);
				if(c2)
				{
					System.out.println("Book deleted from cart Successfully");
				}
				else
				{
					System.out.println("Book not deleted");
				}
				break;
          case 4:
				
				System.out.println("Enter email id to delete:");
				emailId=sc.next();
				
				cart=new Cart();
				
				cart.setEmailId(emailId);
				cartdao=new CartDaoImpl();
				boolean c3=cartdao.clearCart(emailId);
				if(c3)
				{
					System.out.println("Clear cart Successfully");
				}
				else
				{
					System.out.println("not cleared");
				}
				break;
          case 5:
        	  System.exit(0);
          default:
		    	 System.out.println("Invalid choice");

	  }
	}
}}
