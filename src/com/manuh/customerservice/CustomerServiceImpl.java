package com.manuh.customerservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.manuh.customerdomain.CustomerDetails;

public class CustomerServiceImpl implements CustomerService {

	List<CustomerDetails> customerList = new ArrayList<CustomerDetails>();

	@Override
	public CustomerDetails getCustomer(int custId) {
		// TODO Auto-generated method stub
		for (int i = 0; i < customerList.size(); i++) {
			if (custId == customerList.get(i).getCustId()) {
				return customerList.get(i);
			}

		}

		return null;
	}

	@Override
	public CustomerDetails addCustomer(CustomerDetails customer) {
		// TODO Auto-generated method stub
		customerList.add(customer);
		return customer;
	}

	@Override
	public List<CustomerDetails> getAllCustomers() {
		// TODO Auto-generated method stub

		return customerList;
	}

	@Override
	public boolean deleteCustomer(CustomerDetails customer) {
		// TODO Auto-generated method stub
		customerList.remove(customer);
		return true;
	}

	@Override
	public List<CustomerDetails> topNCustomer(int topN) {
		// TODO Auto-generated method stub
		List<CustomerDetails> topcustomerList = new ArrayList<CustomerDetails>();
		for (int i = 0; i < topN; i++) {
			topcustomerList.add(customerList.get(i));
		}
		return topcustomerList;
	}

	@Override
	public List<CustomerDetails> sortByBillAmt() {
		// TODO Auto-generated method stub
		Collections.sort(customerList, new Comparator<CustomerDetails>() {

			public int compare(CustomerDetails c1, CustomerDetails c2) {
				// TODO Auto-generated method stub
				if (c1.getBillAmt() > c2.getBillAmt())
					return 1;
				return -1;

			}

		});
		return customerList;
	}

	public CustomerDetails updatedDate(int custId) {
		// TODO Auto-generated method stub
		for (CustomerDetails customer : customerList) {
			if (customer.getCustId() == custId) {
				customer.setBillDate(LocalDate.now());
				return customer;
			}
		}
		return null;
	}

}