package practice.crm.dao;

import java.util.List;

import practice.crm.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(Integer id);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(Customer cust);
}
