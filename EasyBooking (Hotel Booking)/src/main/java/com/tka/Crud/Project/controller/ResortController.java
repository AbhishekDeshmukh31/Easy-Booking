package com.tka.Crud.Project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.tka.Crud.Project.dao.CustomerRepository;
import com.tka.Crud.Project.entity.Customer;
import com.tka.Crud.Project.service.ResortService;

@RestController
public class ResortController {

	@Autowired
	ResortService resortservice;

	@GetMapping("/getallbooking")
	public List<Customer> getallBookingAPI() {
		List<Customer> getallBooking = resortservice.getallBookingserviceAPI();
		return getallBooking;
	}

	@GetMapping("/getonebooking")
	public Customer getoneBookingAPI(@RequestParam("id") int c_id) {
		Customer customer = resortservice.getsingleBookingserviceAPI(c_id);
		System.out.println(customer);
		return customer;
	}

	@PostMapping("/addsinglebooking")
	public String addBookingAPI(@RequestBody Customer allbooking) {
		return resortservice.addBookingserviceAPI(allbooking);
	}

	@PostMapping("/allmultiplebooking")
	public String addallBookingAPI(@RequestBody List<Customer> allbooking) {
		return resortservice.addallBookingserviceAPI(allbooking);
	}

	@DeleteMapping("/deletebooking")
	public String deleteBookingAPI(@RequestParam("id") int c_id) {
		return resortservice.deleteBookingserviceAPI(c_id);
	}

	@PatchMapping("/updatebooking")
	public String updateBookingAPI(@RequestBody Customer customer, @RequestParam("id") int c_id) {
		return resortservice.updateBookingserviceAPI(customer, c_id);
	}

	@GetMapping("/gettotalbooking")
	public String gettotalBookingAPI() {
		return resortservice.gettotalBookingserviceAPI();
	}

	@GetMapping("/bookingbyroom")
	public List<Customer> getBookingbyroomtypeAPI(@RequestParam("room") String roomtype) {
		return resortservice.getCustomersbyroomtype(roomtype);
	}

	@GetMapping("/bookingbynoofpeople")
	public List<Customer> getcustomerbynoofpeopleAPI(@RequestParam("noof") int noofpeople) {
		return resortservice.getCustomersByNoOfPeople(noofpeople);
	}
	
	@GetMapping("/totalnoofpeople")
	public String gettotalnoofpeopleAPI() {
		return resortservice.getTotalPeopleFromBooking();
	}

	@GetMapping("/roomavailable")
	public List<Customer> getroomAPI(@RequestParam("room") String roomtype, @RequestParam("inn") String checkinn,
			@RequestParam("out") String checkout) {
		return resortservice.getCustomersByRoomAndDateRange(roomtype, checkinn, checkout);
	}

}
