package practice.orm.hib.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.addAnnotatedClass(practice.orm.hib.model.Employee.class);
        	configuration.configure("hibernate.cfg.xml");
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        										.applySettings(configuration.getProperties())
        										.build();
        	SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        	return sf;
		} catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}
		public static SessionFactory getSessionFactory() {
			if(sessionFactory == null) sessionFactory = buildSessionFactory();
	        return sessionFactory;
	    }
}

