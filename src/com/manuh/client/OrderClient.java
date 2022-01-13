package com.manuh.client;

import java.time.LocalDate;

import com.customer.util.OrderServiceJdbcImpl;
import com.manuh.customerdomain.OrderDetails;

public class OrderClient {
	public static void main(String[] args) {

		OrderDetails o = new OrderDetails(109, LocalDate.of(2021, 12, 05), LocalDate.now(), "Mickey", "visakhapatnam",
				"7799097929", 5, 50, "Cash");

		OrderDetails o1 = new OrderDetails(19, LocalDate.of(2021, 12, 9), LocalDate.now(), "Minnie",
				"akkayyapalem,visakhapatnam,530016", "8309144358", 4, 300, "UPI");
		OrderDetails o2 = new OrderDetails(20, LocalDate.of(2021, 12, 11), LocalDate.now(), "pluto",
				"akkayyapalem,visakhapatnam,530016", "8309144358", 4, 800, "Card");
//
//		OrderService s = new OrderServiceImpl();
//		s.addOrders(o);
//		s.addOrders(o1);
//		s.addOrders(o2);
//
//		s.getAllOrders();
//		System.out.println(s.getAllOrders());
//		System.out.println(s.getOrdersByCustId(120));

		OrderServiceJdbcImpl obj = new OrderServiceJdbcImpl();
//
	//	System.out.println(obj.addOrders(o));
//		System.out.println(obj.addOrders(o1));
		//System.out.println(obj.addOrders(o2));

		 System.out.println(obj.getAllOrders());

		System.out.println(obj.getOrdersByCustId(109));
	}

}
