package com.customer.util;

import java.util.List;

import com.manuh.customerdomain.CustomerDetails;
import com.manuh.customerservice.CustomerService;

public class CustomerServiceJdbcImpl implements CustomerService {

	CustomerJdbcUtil util = new CustomerJdbcUtil();
	CustomerDetails cd = new CustomerDetails();

	@Override
	public CustomerDetails addCustomer(CustomerDetails customer) {
		// TODO Auto-generated method stub
		return util.insert(customer);
	}

	@Override
	public List<CustomerDetails> getAllCustomers() {
		// TODO Auto-generated method stub
		return util.getAllCustomers();

	}

	@Override
	public boolean deleteCustomer(CustomerDetails customer) {
		// TODO Auto-generated method stub
		util.deleteCustomer(customer.getCustId());
		return true;
	}

	@Override
	public List<CustomerDetails> topNCustomer(int topN) {
		// TODO Auto-generated method stub
		return util.topNCustomer(topN);
	}

	@Override
	public List<CustomerDetails> sortByBillAmt() {
		// TODO Auto-generated method stub
		return util.sortByBillAmt();
	}

	@Override
	public CustomerDetails updatedDate(int custId) {
		// TODO Auto-generated method stub
		return util.updatedDate(custId);
	}

	@Override
	public CustomerDetails getCustomer(int custId) {
		// TODO Auto-generated method stub
		return util.getCustomer(custId);
	}

}