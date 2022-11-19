package com.mytechjourney.postgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mytechjourney.postgres.model.CustomerDetails;
import com.mytechjourney.postgres.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    
    // Create
    @PostMapping("/addCustomer")
    public String AddCustomer(@RequestBody CustomerDetails customerDetails){
        return customerService.createCustomer(customerDetails);
    }

    // Read
    @GetMapping("/getCustomer/{id}")
    public Object GetCustomer(@PathVariable(name = "id") Integer id){
        return customerService.getCustomer(id);
    }

    // Update
    @PostMapping("/updateCustomer/{id}")
    public String UpdateCustomer(@PathVariable(name = "id") Integer id, @RequestBody CustomerDetails customerDetails){
        return customerService.updateCustomer(id, customerDetails);
    }

    // Delete
    @PostMapping("/deleteCustomer/{id}")
    public String DeleteCustomer(@PathVariable Integer id){
        return customerService.deleteCustomer(id);
    }
}
