package com.apex.bean;

import java.sql.Date;

public class OrderBean {
	
	public OrderBean() {}
	
	public OrderBean(int orderID, int customerID, int employeeID, Date orderDate, int shipperID) {
		this.OrderID = orderID;
		this.CustomerID = customerID;
		this.EmployeeID = employeeID;
		this.OrderDate = orderDate;
		this.ShipperID = shipperID;
	}
	private int OrderID;
	private int CustomerID;
	private int EmployeeID;
	private Date OrderDate;
	private int ShipperID;
	
	
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public int getShipperID() {
		return ShipperID;
	}
	public void setShipperID(int shipperID) {
		ShipperID = shipperID;
	}
};
