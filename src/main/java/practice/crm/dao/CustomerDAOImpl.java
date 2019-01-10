package practice.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import practice.crm.entity.Customer;

@Repository // specifies this is a spl type of component (used for DAO's)
public class CustomerDAOImpl implements CustomerDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> qry = session.createQuery("from Customer order by firstName", Customer.class);
		// set this query cacheable
		qry.setCacheable(true);
		List<Customer> customers = qry.getResultList();
		return customers;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveCustomer(Customer customer) {
		if(customer.equals(new Customer())) {
			System.out.println("empty object ...");
			return;
		}
		//  no need for transaction here it's taken care by @Transactional in service method
		Session session = sessionFactory.getCurrentSession();
		// this will either insert or update existing record
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.update(customer);
		
	}

	@Override
	public void deleteCustomer(Customer cust) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cust);
		
	}

}
