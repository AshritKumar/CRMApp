package practice.crm.service;

import java.util.List;

import practice.crm.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(Integer id);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(Customer cust);
}
