package com.manuh.customerdomain;

import java.time.LocalDate;

public class OrderDetails {
	private int orderNo;
	private LocalDate orderDate, deliveryDate;
	private String customerName, address, phoneNo;
	private int noOfOrders;
	private float billAmount;
	private String paymentType;

	public OrderDetails(int orderNo, LocalDate orderDate, LocalDate deliveryDate, String customerName, String address,
			String phoneNo, int noOfOrders, float billAmount, String paymentType) {
		super();
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.customerName = customerName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.noOfOrders = noOfOrders;
		this.billAmount = billAmount;
		this.paymentType = paymentType;
	}

	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getNoOfOrders() {
		return noOfOrders;
	}

	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}

	public float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderNo=" + orderNo + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate
				+ ", customerName=" + customerName + ", address=" + address + ", phoneNo=" + phoneNo + ", noOfOrders="
				+ noOfOrders + ", billAmount=" + billAmount + ", paymentType=" + paymentType + "]";
	}

}
