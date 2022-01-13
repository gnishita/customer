package com.customer.util;

import java.util.List;
import java.util.Map;

import com.manuh.customerdomain.OrderDetails;
import com.order.service.OrderService;

public class OrderServiceJdbcImpl implements OrderService{

	OrderJdbcUtil od = new OrderJdbcUtil();
	@Override
	public Map<Integer, List<OrderDetails>> addOrders(OrderDetails orders) {
		// TODO Auto-generated method stub
		return od.addOrders(orders);
	}

	@Override
	public Map<Integer, List<OrderDetails>> getAllOrders() {
		// TODO Auto-generated method stub
		return od.getAllOrders();
	}

	@Override
	public List<OrderDetails> getOrdersByCustId(int custId) {
		// TODO Auto-generated method stub
		return od.getOrdersByCustId(custId);
	}

}
