package com.manuh.client;

import java.sql.SQLException;
import java.time.LocalDate;

import com.manuh.customerservice.CustomerServiceImpl;
import com.customer.util.CustomerJdbcUtil;
import com.customer.util.CustomerServiceJdbcImpl;
import com.manuh.customerdomain.CustomerDetails;
import com.manuh.customerservice.CustomerService;

public class CustomerClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDetails c = new CustomerDetails(110, 129, "Mickey", "Mouse", "7799097929", "Visakhapatnam", 530024,
				LocalDate.of(2021, 05, 25), 200, 4);
		CustomerDetails c1 = new CustomerDetails(19, 120, "Minnie", "Mouse", "8309144358", "Visakhapatnam", 530016,
				LocalDate.of(2021, 12, 21), 150, 2);
		CustomerDetails c2 = new CustomerDetails(191, 220, "Pluto", "Moni", "9988776655", "Paderu", 500016,
				LocalDate.of(2021, 12, 20), 5, 450);

//		System.out.println(c);
//		System.out.println(c1);

//	CustomerService service = new CustomerServiceImpl();
//		service.addCustomer(c);
//		service.addCustomer(c1);
//		service.addCustomer(c2);
//
//		service.getAllCustomers();
		// System.out.println(service.getAllCustomers());
		// service.deleteCustomer(c);
		// System.out.println(service.getAllCustomers());
		// System.out.println(service.getCustomer(110));
		// System.out.println(service.topNCustomer(1));
//		System.out.println(service.sortByBillAmt());
//		System.out.println(service.updatedDate(110));

		/*
		 * c.setCustId(110); c.setFirstName("Mickey"); c.setLastName("Mouse");
		 * c.setPhoneNo("7799097929");
		 * c.setAddress("Kailashpuram, Visakhapatnam, 530024");
		 * c.setBillDate("11-11-21");
		 * 
		 * c1.setCustId(19); c1.setFirstName("Minnie"); c1.setLastName("Mouse");
		 * c1.setPhoneNo("8309144358");
		 * c1.setAddress("Akkayyapalem, Visakhapatnam, 530016");
		 * c1.setBillDate("11-11-21");
		 * 
		 * System.out.println("Customer details:"); System.out.println("\nID\t\t: " +
		 * c.custId + "\nFirst_Name\t: " + c.firstName + "\nLast_Name\t: " + c.lastName
		 * + "\nPhoneNo\t\t: " + c.getPhoneNo() + "\nAddress\t\t: " + c.address +
		 * "\nBill_Date\t: " + c.billDate); System.out.println("\nID\t\t: " + c1.custId
		 * + "\nFirst_Name\t: " + c1.firstName + "\nLast_Name\t: " + c1.lastName +
		 * "\nPhoneNo\t\t: " + c1.getPhoneNo() + "\nAddress\t \t: " + c1.address +
		 * "\nBill_Date\t: " + c1.billDate);
		 */
		CustomerServiceJdbcImpl obj = new CustomerServiceJdbcImpl();
//		CustomerJdbcUtil obj1 = new CustomerJdbcUtil();
//		try {
//			System.out.println(obj1.getConnection());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// System.out.println(obj.addCustomer(c1));
		// System.out.println(obj.addCustomer(c2));

//		System.out.println(obj.getAddCustomer());
//		System.out.println(obj.topNCustomer(1));
//		System.out.println(obj.updatedDate(101));
System.out.println(obj.getCustomer(19));
//		System.out.println(obj.deleteCustomer(c1));
//
//		System.out.println(obj.getAllCustomers());
//		System.out.println(obj.sortByBillAmt());
	}

//	private static customerDetails getcustomerDetails(int custId, String firstName, String lastName, String phoneNo, String city, long pincode, String billDate) {
//		// TODO Auto-generated method stub
//		
//		customerDetails c=new customerDetails();
//		c.setCustId(custId);
//		c.setFirstName(firstName);
//		c.setLastName(lastName);
//		c.setPhoneNo(phoneNo);
//		c.setCity(city);
//		c.setPincode(pincode);
//		c.setBillDate(billDate);
//		return c;
//	}

//	CustomerServiceJdbcImpl obj = new CustomerServiceJdbcImpl();
//	obj.getAllCustomers();
}