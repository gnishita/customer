package com.manuh.customerdomain;

import java.time.LocalDate;

public class CustomerDetails {
	private int custId, billAmt, itemQuantity, orderNo;
	private long pincode;
	private String firstName, lastName, phoneNo, city;
	private LocalDate billDate;

	public CustomerDetails(int custId, int orderNo, String firstName, String lastName, String phoneNo, String city,
			long pincode, LocalDate billDate, int billAmt, int itemQuantity) {
		super();
		this.custId = custId;
		this.orderNo = orderNo;
		this.billAmt = billAmt;
		this.itemQuantity = itemQuantity;
		this.pincode = pincode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.city = city;
		this.billDate = billDate;
	}

	public CustomerDetails() {

	}

	public int getCustId() {
		return custId;
	}

	public CustomerDetails(int orderNo) {
		super();
		this.orderNo = orderNo;
	}

	public int getBillAmt() {
		return billAmt;
	}

	public void setBillAmt(int billAmt) {
		this.billAmt = billAmt;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "CustomerDetails [custId=" + custId + ", billAmt=" + billAmt + ", itemQuantity=" + itemQuantity
				+ ", orderNo=" + orderNo + ", pincode=" + pincode + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phoneNo=" + phoneNo + ", city=" + city + ", billDate=" + billDate + "]";
	}

}
