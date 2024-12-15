package com.tka.Crud.Project.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.tka.Crud.Project.dao.CustomerRepository;
import com.tka.Crud.Project.dao.ResortDao;
import com.tka.Crud.Project.entity.Customer;

@Service
public class ResortService {

	@Autowired
	ResortDao resortdao;

	@Autowired
	SessionFactory sessionFactory;

	public List<Customer> getallBookingserviceAPI() {
		List<Customer> getallBookings = resortdao.getallBookingdaoAPI();
		return getallBookings;
	}

	public String addBookingserviceAPI(Customer allbooking) {
		return resortdao.addBookingdaoAPI(allbooking);
	}

	public String addallBookingserviceAPI(List<Customer> customer) {
		return resortdao.addmultipleBookingdaoAPI(customer);
	}

	public Customer getsingleBookingserviceAPI(int c_id) {
		return resortdao.getsingleBookingdaoAPI(c_id);
	}

	public String deleteBookingserviceAPI(int c_id) {
		return resortdao.deleteBookingdaoAPI(c_id);
	}

	public String updateBookingserviceAPI(Customer customer, int c_id) {
		return resortdao.updateoneBookingdaoAPI(customer, c_id);
	}

	@SuppressWarnings("deprecation")
	public String gettotalBookingserviceAPI() {
		Session session = null;
		long count = 0;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			count = (long) session.createQuery("SELECT COUNT(c)from Customer c").getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		return "Total count of bookings is: " + count;
	}

	@SuppressWarnings("deprecation")
	public String getTotalPeopleFromBooking() {
		Session session = null;
		long totalPeople = 0;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			totalPeople = (long) session.createQuery("SELECT SUM(c.noofpeople) FROM Customer c").getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
		return "Total number of people from bookings is: " + totalPeople;
	}

	public List<Customer> getCustomersbyroomtype(String roomtype) {
		Session session = null;
		List<Customer> customerbyroom = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			customerbyroom = session.createQuery("from Customer where roomtype = :roomtype", Customer.class)
					.setParameter("roomtype", roomtype).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customerbyroom;
	}

	public List<Customer> getCustomersByNoOfPeople(int noofPeople) {
		Session session = null;
		List<Customer> customers = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			customers = session.createQuery("FROM Customer WHERE noofpeople = :noofpeople", Customer.class)
					.setParameter("noofpeople", noofPeople).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customers;
	}

	public List<Customer> getCustomersByRoomAndDateRange(String roomtype, String checkinn, String checkout) {
		Session session = null;
		List<Customer> customers = null;
		try {
			session = sessionFactory.openSession();

			String hql = "FROM Customer WHERE roomtype = :roomtype AND ((checkinn BETWEEN :checkinn AND :checkout) OR (checkout BETWEEN :checkinn AND :checkout))";
			Query<Customer> query = session.createQuery(hql, Customer.class);
			query.setParameter("roomtype", roomtype);
			query.setParameter("checkinn", checkinn);
			query.setParameter("checkout", checkout);

			customers = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customers;
	}
}
