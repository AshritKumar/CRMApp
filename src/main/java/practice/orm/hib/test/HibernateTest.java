package practice.orm.hib.test;

import java.util.Date;

import org.hibernate.Session;

import practice.orm.hib.model.Employee;
import practice.orm.hib.util.HibernateUtil;

public class HibernateTest {
	
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("Pankaj");
		emp.setRole("CEO");
		emp.setInsertTime(new Date());
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		System.out.println("Employee ID="+emp.getId());
		
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
	}

}
