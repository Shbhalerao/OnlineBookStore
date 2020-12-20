package com.onlinebookstore.pojo;

public class Cart
{
   private int cartId;
   private int bookId;
   private int bookQuantity;
   private String emailId;
   private String bookName;
   private String price;
public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public int getBookQuantity() {
	return bookQuantity;
}
public void setBookQuantity(int bookQuantity) {
	this.bookQuantity = bookQuantity;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
@Override
public String toString() {
	return "Cart [cartId=" + cartId + ", bookId=" + bookId + ", bookQuantity=" + bookQuantity + ", emailId=" + emailId
			+ ", bookName=" + bookName + ", price=" + price + "]";
}
   
   
   
   
}
