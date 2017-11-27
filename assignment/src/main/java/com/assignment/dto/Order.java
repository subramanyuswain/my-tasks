package com.assignment.dto;

public class Order {
	
	private OrderDetail orderDetail;
	private String date;
	private String status;
	private int total;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderDetail=" + orderDetail + ", date=" + date + ", status=" + status + "]";
	}

}
