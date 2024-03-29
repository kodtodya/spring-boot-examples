package com.kodtodya.practice.service;

import com.kodtodya.practice.domain.Customer;
import com.kodtodya.practice.model.CustomerModel;
import com.kodtodya.practice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("customerService")
public class DefaultCustomerService implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Create a customer based on the data sent to the service class.
     * @param customer
     * @return DTO representation of the customer
     */
    @Override
    public CustomerModel saveCustomer(CustomerModel customer) {
        Customer customerModel = populateCustomerEntity(customer);
        return populateCustomerModel(customerRepository.save(customerModel));
    }

    /**
     * Delete customer based on the customer ID.We can also use other option to delete customer
     * based on the entoty (passing JPA entity class as method parameter)
     * @param customerId
     * @return boolean flag indicating the request status
     */
    @Override
    public boolean deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }

    /**
     * Method to return list of all the available customers in the system.This is a simple
     * implementation but you might want to use pagination in the real world example.
     * @return list of customer
     */
    @Override
    public List<CustomerModel> getAllCustomers() {
        List<CustomerModel> customers = new ArrayList<>();
        List<Customer> customerList = customerRepository.findAll();
        customerList.forEach(customer -> {
            customers.add(populateCustomerModel(customer));
        });
        return customers;
    }

    /**
     * Get customer by ID.The service will send the customer data else will throw the exception.
     * @param customerId
     * @return CustomerModel
     */
    @Override
    public CustomerModel getCustomerById(Long customerId) {
        return populateCustomerModel( customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found")));
    }

    /**
     * Internal method to convert Customer JPA entity to the DTO object
     * for frontend data
     * @param customer
     * @return CustomerModel
     */
    private CustomerModel populateCustomerModel(final Customer customer){
        CustomerModel customerModel = new CustomerModel();
        customerModel.setId(customer.getId());
        customerModel.setFirstName(customer.getFirstName());
        customerModel.setLastName(customer.getLastName());
        customerModel.setEmail(customer.getEmail());
        return  customerModel;
    }

    /**
     * Method to map the frontend customer object to the JPA customer entity.
     * @param customerModel
     * @return Customer
     */
    private Customer populateCustomerEntity(CustomerModel customerModel){
        Customer customer = new Customer();
        customer.setFirstName(customerModel.getFirstName());
        customer.setLastName(customerModel.getLastName());
        customer.setEmail(customerModel.getEmail());
        return  customer;
    }
}
