package com.customer.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.manuh.customerdomain.CustomerDetails;

public class CustomerJdbcUtil {
	CustomerDetails cd = new CustomerDetails();
	Statement stmt;
	PreparedStatement prepStatement;
	ResultSet rs;

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

//	public List<CustomerDetails> executeStatement(String query) throws SQLException {
//		ArrayList list = new ArrayList<>();
//		stmt = getConnection().createStatement();
//		ResultSet rs = stmt.executeQuery("select * from customerdetails"); // the query is stored in rs(result set)
//		while (rs.next()) {
//			list.add(rs);
//
//		}
//		return list;
//	}

//	public List<CustomerDetails> executeStatement(String query) throws SQLException {
//		Statement stmt = getConnection().createStatement();
//		ResultSet rs = stmt.executeQuery("select * from customerdetails"); // the query is stored in rs(result set)
//		while (rs.next()) {
//			System.out.println("Cust ID=" + rs.getInt("custId") + ", Name=" + rs.getString("firstname"));
//		}
//		return null;
//	}

	public CustomerDetails insert(CustomerDetails customer) {
		// TODO Auto-generated method stub

		try {
			// java.sql.Date billDate = rs.getDate("billDate");
			String insertStmt = "insert into customerdetails values(?,?,?,?,?,?,?,?,?,?) ";

			PreparedStatement stmt1 = getConnection().prepareStatement(insertStmt);
			stmt1.setInt(1, customer.getCustId());
			stmt1.setInt(2, customer.getOrderNo());
			stmt1.setString(3, customer.getFirstName());
			stmt1.setString(4, customer.getLastName());
			stmt1.setString(5, customer.getPhoneNo());
			stmt1.setString(6, customer.getCity());
			stmt1.setLong(7, customer.getPincode());
			stmt1.setDate (8, Date.valueOf( customer.getBillDate()));
			stmt1.setInt(9, customer.getBillAmt());
			stmt1.setInt(10, customer.getItemQuantity());

			stmt1.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customer;
	}

	public List<CustomerDetails> getAllCustomers() {
		List<CustomerDetails> list = new ArrayList<>();

		try {

			prepStatement = getConnection().prepareStatement("select * from customerdetails");
			ResultSet rs = prepStatement.executeQuery(); // the query is stored in
															// rs(result set)

			while (rs.next()) {
				 java.sql.Date billDate = rs.getDate("billDate");

//				cd.setCustId(rs.getInt("custId"));
//				cd.setOrderNo(rs.getInt("orderNo"));
//				cd.setFirstName(rs.getString("firstName"));
//				cd.setLastName(rs.getString("lastName"));
//				cd.setPhoneNo(rs.getString("phoneNo"));
//				cd.setCity(rs.getString("city"));
//				cd.setPincode(rs.getLong("pincode"));
//				// cd.setBillDate(rs.getDate("billDate"));
//				cd.setBillAmt(rs.getInt("billAmt"));
//				cd.setItemQuantity(rs.getInt("itemQuantity"));
				list.add(new CustomerDetails(rs.getInt("custId"), rs.getInt("orderNo"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("phoneNo"), rs.getString("city"), rs.getLong("pincode"),
						billDate.toLocalDate(), rs.getInt("billAmt"), rs.getInt("itemQuantity")));

			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CustomerDetails> topNCustomer(int n) {
		List<CustomerDetails> topNList = new ArrayList<>();

		// prepStatement.setInt(1, n);

		try {

			prepStatement = getConnection().prepareStatement("SELECT * FROM customerdetails");
			prepStatement.setMaxRows(n);
//			prepStatement = util.getConnection().prepareStatement("select * from customerdetails");
			rs = prepStatement.executeQuery(); // the query is stored in
												// rs(result set)
			// return rs.getInt("custId")+" "+rs.getInt("orderNo")+"
			// "+rs.getString("firstName");
			while (rs.next()) {
				 java.sql.Date billDate = rs.getDate("billDate");

//				cd.setCustId(rs.getInt("custId"));
//				cd.setOrderNo(rs.getInt("orderNo"));
//				cd.setFirstName(rs.getString("firstName"));
//				cd.setLastName(rs.getString("lastName"));
//				cd.setPhoneNo(rs.getString("phoneNo"));
//				cd.setCity(rs.getString("city"));
//				cd.setPincode(rs.getLong("pincode"));
//				//cd.setBillDate(rs.getDate("billDate"));
//				cd.setBillAmt(rs.getInt("billAmt"));
//				cd.setItemQuantity(rs.getInt("itemQuantity"));
				topNList.add(new CustomerDetails(rs.getInt("custId"), rs.getInt("orderNo"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("phoneNo"), rs.getString("city"), rs.getLong("pincode"),
						billDate.toLocalDate(), rs.getInt("billAmt"), rs.getInt("itemQuantity")));

			}

			return topNList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteCustomer(int custId) {
		try {
			String deleteStmt = "DELETE FROM customerdetails WHERE custId=?";
			PreparedStatement prepStatement = getConnection().prepareStatement(deleteStmt);
			prepStatement.setInt(1, custId);
			prepStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public CustomerDetails updatedDate(int custId) {

		CustomerDetails customer = new CustomerDetails();
		try {
			PreparedStatement prepStatement;
			prepStatement = getConnection().prepareStatement("update customerdetails set billDate=? where custId= ?");
			prepStatement.setDate(1, Date.valueOf(LocalDate.now()));// converting LocalDate to SQLDate

			prepStatement.setInt(2, custId);
			prepStatement.execute();
			
			
			//////
			//PreparedStatement prepStatement;

			prepStatement = getConnection().prepareStatement(
					"select * from customerdetails where custId = ?");/*
																	 * we passing the SQL query in the prepStatment.
																	 */
			prepStatement.setInt(1,custId);
			ResultSet rs = prepStatement.executeQuery();// We are executing the query by using executeQurey
			// to go the next iteration we need rs.next()
			while (rs.next()) {
				// java.sql.Date sqlDate =new java.sql.Date(new Date().getTime());
				java.sql.Date sqlDate = rs.getDate("billDate");
				LocalDate billDate = sqlDate.toLocalDate();
				customer = (new CustomerDetails(rs.getInt("custId"), rs.getInt("orderNo"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("phoneNo"), rs.getString("city"), rs.getLong("pincode"),
						billDate, rs.getInt("billAmt"), rs.getInt("itemQuantity")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;

	}

	public List<CustomerDetails> sortByBillAmt() {
		List<CustomerDetails> customerListByBillAmt = new ArrayList<CustomerDetails>();
		try {
			prepStatement = getConnection().prepareStatement("select * from customerdetails order by billAmt Desc");
			ResultSet rs = prepStatement.executeQuery();

			while (rs.next()) {
				java.sql.Date sqlDate = rs.getDate("billDate");
				LocalDate billDate = sqlDate.toLocalDate();
				customerListByBillAmt
						.add(new CustomerDetails(rs.getInt("custId"), rs.getInt("orderNo"), rs.getString("firstName"),
								rs.getString("lastName"), rs.getString("phoneNo"), rs.getString("city"),
								rs.getLong("pincode"), billDate, rs.getInt("billAmt"), rs.getInt("itemQuantity")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerListByBillAmt;

	}
	
	public CustomerDetails getCustomer(int custId) {
		//List<CustomerDetails> getCustomer = new ArrayList<CustomerDetails>();
		CustomerDetails customer = new CustomerDetails();
	try {
		PreparedStatement prepStatement;

		prepStatement = getConnection().prepareStatement(
				"select * from customerdetails where custId = ?");/*
																 * we passing the SQL query in the prepStatment.
																 */
		prepStatement.setInt(1,custId);
		ResultSet rs = prepStatement.executeQuery();// We are executing the query by using executeQurey
		// to go the next iteration we need rs.next() method
		while (rs.next()) {
			 java.sql.Date billDate = rs.getDate("billDate");

//			cd.setCustId(rs.getInt("custId"));
//			cd.setOrderNo(rs.getInt("orderNo"));
//			cd.setFirstName(rs.getString("firstName"));
//			cd.setLastName(rs.getString("lastName"));
//			cd.setPhoneNo(rs.getString("phoneNo"));
//			cd.setCity(rs.getString("city"));
//			cd.setPincode(rs.getLong("pincode"));
//			//cd.setBillDate(rs.getDate("billDate"));
//			cd.setBillAmt(rs.getInt("billAmt"));
//			cd.setItemQuantity(rs.getInt("itemQuantity"));
			 customer = (new CustomerDetails(rs.getInt("custId"), rs.getInt("orderNo"), rs.getString("firstName"),
					rs.getString("lastName"), rs.getString("phoneNo"), rs.getString("city"), rs.getLong("pincode"),
					billDate.toLocalDate(), rs.getInt("billAmt"), rs.getInt("itemQuantity")));

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return customer;
}}
