package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	// id를 받아서 맵을 만들어 db저장. 
	
	private Map<String, Customer> customers;
	
	private static final CustomerService instance = new CustomerService();

	private CustomerService() {
		customers = new HashMap<String, Customer>();
	}
	
	public static CustomerService getInstance() {
		return instance;
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}
	
	public Customer findCustomer(String id) {
		if( id != null ) {
			return (customers.get(id.toLowerCase()));
		}
		else return null;
	}
		
	public Customer login(String id, String password){
		Customer customer = findCustomer(id);
		if( customer.getPassword().equals(password) ) {
			return customer;
		}
		else return null;
	}
	
}
