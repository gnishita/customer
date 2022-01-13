package com.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manuh.customerdomain.OrderDetails;

public class OrderServiceImpl implements OrderService {
	Map<Integer, List<OrderDetails>> orderList = new HashMap<>();

	@Override
	public Map<Integer, List<OrderDetails>> addOrders(OrderDetails orders) {
		// TODO Auto-generated method stub

		orderList.put(orders.getOrderNo(), new ArrayList<OrderDetails>());
		orderList.get(orders.getOrderNo()).add(orders);
		return orderList;
	}

	@Override
	public Map<Integer, List<OrderDetails>> getAllOrders() {
		// TODO Auto-generated method stub
		return orderList;
	}

	@Override
	public List<OrderDetails> getOrdersByCustId(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	//public List<OrderDetails> getOrdersByCustId(int custId) {
		// TODO Auto-generated method stub

	}

//}
