package com.onlinebookstore.pojo;

public class Order
{
   private int orderId;
   private String orderStatus;
   private double totalBill;
   private String email;
   private String orderDate;
public String getOrderDate() {
	return orderDate;
}
public void setOrderDate(String orderDate) {
	this.orderDate = orderDate;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}
public double getTotalBill() {
	return totalBill;
}
public void setTotalBill(double totalBill) {
	this.totalBill = totalBill;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", totalBill=" + totalBill + ", email="
			+ email + ", orderDate=" + orderDate + "]";
}

 

   
}
