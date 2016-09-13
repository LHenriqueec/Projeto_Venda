package dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionFactory {

	private static SessionFactory factory;
	
	public static void initSetup() {
		Configuration config = new Configuration().configure();
		
		if (factory == null) factory = config.buildSessionFactory();
	}
	
	public static Session getSession() {
		return factory.openSession();
		
	}
	
	public static void closeFactory() {
		factory.close();
	}
}
