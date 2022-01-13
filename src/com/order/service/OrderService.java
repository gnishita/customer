package com.order.service;

import java.util.List;
import java.util.Map;

import com.manuh.customerdomain.OrderDetails;

public interface OrderService {

	public Map<Integer, List<OrderDetails>> addOrders(OrderDetails orders);

	public Map<Integer, List<OrderDetails>> getAllOrders();

	public List<OrderDetails> getOrdersByCustId(int custId);

}
