package com.tka.Crud.Project.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.Crud.Project.entity.Customer;

@Repository
public class ResortDao {

	@Autowired
	SessionFactory sessionFactory;

	public Customer getsingleBookingdaoAPI(int c_id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session.get(Customer.class, c_id);
	}

	public List<Customer> getallBookingdaoAPI() {
		Session session = null;
		List<Customer> allList = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			allList = session.createQuery("from Customer", Customer.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		return allList;
	}

	public String addBookingdaoAPI(Customer allbooking) {
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.persist(allbooking);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
		return "Booking Saved successfully";
	}

	public String addmultipleBookingdaoAPI(List<Customer> allbooking) {

		Session session = sessionFactory.openSession();
		for (Customer customer : allbooking) {
			Transaction tx = session.beginTransaction();
			session.persist(customer);
			tx.commit();
		}
		sessionFactory.close();
		session.close();
		return "Booking List saved successfully";
	}

	public String deleteBookingdaoAPI(int c_id) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			List<Customer> allList = session.createQuery("from Customer", Customer.class).list();
			for (Customer customer : allList) {
				if (customer.getC_id() == c_id) {
					session.remove(allList);
					tx.commit();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		return "Customer Booking was deleted";
	}

	public String updateoneBookingdaoAPI(Customer updatedcustomer, int c_id) {

		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Customer existingcustomer = session.get(Customer.class, c_id);
			if (existingcustomer != null) {
				existingcustomer.setName(updatedcustomer.getName());
				existingcustomer.setNoofpeople(updatedcustomer.getNoofpeople());
				existingcustomer.setRoomtype(updatedcustomer.getRoomtype());
				existingcustomer.setCheckinn(updatedcustomer.getCheckinn());
				existingcustomer.setCheckout(updatedcustomer.getCheckout());
				session.merge(existingcustomer);
				tx.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return "Booking details updated";
	}

}
