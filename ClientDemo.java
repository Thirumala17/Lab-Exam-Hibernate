package com.klef.jfsd.exam;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;

	public class ClientDemo {
	    public static void main(String[] args) {
	        Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();

	        
	        Department dept = new Department();
	        dept.setName("Computer Science");
	        dept.setLocation("Building A");
	        dept.setHodName("Dr. Smith");
	        session.save(dept);

	        String hql = "DELETE FROM Department WHERE departmentId = :id";
	        session.createQuery(hql).setParameter("id", 1).executeUpdate();

	        tx.commit();
	        session.close();
	        factory.close();
	    }
	}

