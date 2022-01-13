package com.customer.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manuh.customerdomain.OrderDetails;

public class OrderJdbcUtil {
	OrderDetails od = new OrderDetails();
	Statement stmt;
	PreparedStatement prepStatement;
	ResultSet rs;
	
	Map<Integer, List<OrderDetails>> orderList = new HashMap<>();


	public Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nishita", "root", "gni@manuh9");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found !!" + e.getMessage());
			e.printStackTrace();
		}
		return connection;

	}

	public Map<Integer, List<OrderDetails>> addOrders(OrderDetails orders) {
		// TODO Auto-generated method stub

		try {
			// java.sql.Date billDate = rs.getDate("billDate");
			//stmt = util.getConnection().createStatement();

			String insertStmt = "insert into orderdetails values(?,?,?,?,?,?,?,?,?) ";

			PreparedStatement stmt = getConnection().prepareStatement(insertStmt);
			stmt.setInt(1, orders.getOrderNo());
			stmt.setDate(2, Date.valueOf(orders.getOrderDate()));
			stmt.setDate(3, Date.valueOf(orders.getDeliveryDate()));
			stmt.setString(4, orders.getCustomerName());
			stmt.setString(5, orders.getAddress());
			stmt.setString(6, orders.getPhoneNo());
			stmt.setInt(7, orders.getNoOfOrders());
			stmt.setString(9, orders.getPaymentType());
			stmt.setFloat(8, orders.getBillAmount());

			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orderList;
	}

	public  Map<Integer, List<OrderDetails>> getAllOrders(){
		Map<Integer, List<OrderDetails>> orderList2 = new HashMap<>();
		List<OrderDetails> list= new ArrayList<>();
		try {

			prepStatement = getConnection().prepareStatement("select * from orderdetails");
			ResultSet rs = prepStatement.executeQuery(); // the query is stored in
															// rs(result set)

			while (rs.next()) {
				java.sql.Date orderDate = rs.getDate("orderDate");
				java.sql.Date deliveryDate = rs.getDate("deliveryDate");
				
				OrderDetails newRecord=(new OrderDetails(rs.getInt("orderNo"), orderDate.toLocalDate(), deliveryDate.toLocalDate(),
						rs.getString("customerName"), rs.getString("address"), rs.getString("phoneNo"),
						rs.getInt("noOfOrders"), rs.getFloat("billAmount"), rs.getString("paymentType")));
				
				orderList2.put(rs.getInt("orderNo"), new ArrayList<OrderDetails>());
				orderList2.get(newRecord.getOrderNo()).add(newRecord);

				

			}

			return orderList2;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<OrderDetails> getOrdersByCustId(int custId) {
		// List<CustomerDetails> getCustomer = new ArrayList<CustomerDetails>();
		List<OrderDetails> list = new ArrayList<>();
		 OrderDetails orders = new OrderDetails();
		try {
			PreparedStatement prepStatement;

			prepStatement = getConnection().prepareStatement(
					"select * from orderdetails where orderNo = ?");/*
																	 * we passing the SQL query in the prepStatment.
																	 */
			prepStatement.setInt(1, custId);
			ResultSet rs = prepStatement.executeQuery();// We are executing the query by using executeQurey
			// to go the next iteration we need rs.next() method
			while (rs.next()) {

				java.sql.Date orderDate = rs.getDate("orderDate");
				java.sql.Date deliveryDate = rs.getDate("deliveryDate");

				list.add(new OrderDetails(rs.getInt("orderNo"), orderDate.toLocalDate(), deliveryDate.toLocalDate(),
						rs.getString("customerName"), rs.getString("address"), rs.getString("phoneNo"),
						rs.getInt("noOfOrders"), rs.getFloat("billAmount"), rs.getString("paymentType")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}