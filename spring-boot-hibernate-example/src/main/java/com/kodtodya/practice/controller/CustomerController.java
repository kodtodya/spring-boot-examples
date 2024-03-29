package com.kodtodya.practice.controller;

import com.kodtodya.practice.model.CustomerModel;
import com.kodtodya.practice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/customerManagement")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * <p>Get all customer data in the system.For production system you many want to use
     * pagination.</p>
     * @return List<CustomerModel>
     */
    @GetMapping("/customers")
    public List<CustomerModel> getCustomers(){
        return customerService.getAllCustomers();
    }

    /**
     * Method to get the customer data based on the ID.
     * @param id
     * @return CustomerModel
     */
    @GetMapping("/customer/{id}")
    public CustomerModel getCustomer(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    /**
     * Post request to create customer information int the system.
     * @param customerModel
     * @return
     */
    @PostMapping("/customer")
    public CustomerModel saveCustomer(final @RequestBody CustomerModel customerModel){
        return customerService.saveCustomer(customerModel);
    }

    /**
     * Delete customer from the system based on the ID. The method mapping is similar to the getCustomer with difference of
     * @DeleteMapping and @GetMapping
     * @param id
     * @return
     */
    @DeleteMapping("/customer/{id}")
    public Boolean deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}
