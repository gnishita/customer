package com.manuh.customerservice;

import java.util.List;

import com.manuh.customerdomain.CustomerDetails;

public interface CustomerService {

	public CustomerDetails getCustomer(int custId);

	public CustomerDetails addCustomer(CustomerDetails Customer);

	public List<CustomerDetails> getAllCustomers();

	public boolean deleteCustomer(CustomerDetails Customer);

	public List<CustomerDetails> topNCustomer(int topN);

	public List<CustomerDetails> sortByBillAmt();

	public CustomerDetails updatedDate(int custId);

}
