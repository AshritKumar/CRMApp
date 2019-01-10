package practice.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import practice.crm.dao.CustomerDAO;
import practice.crm.entity.Customer;

@Service // says that this is a service
public class CustomerServiceImpl implements CustomerService{
	
	// inject DAO
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional // best practice to manage hiberate transactions in service layer rather than DAO
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(Integer id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer cust) {
		customerDAO.deleteCustomer(cust);
		
	}

}
