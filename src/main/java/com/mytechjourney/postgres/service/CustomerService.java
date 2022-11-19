package com.mytechjourney.postgres.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytechjourney.postgres.entity.Customer;
import com.mytechjourney.postgres.model.CustomerDetails;
import com.mytechjourney.postgres.repositories.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;

    public String createCustomer(CustomerDetails customerDetails){
        try{
            Customer customer = new Customer();
            customer.setName(customerDetails.getName());
            customer.setDob(customerDetails.getDob());
            customer.setAddress(customerDetails.getAddress());
            customer.setMobileNumber(customerDetails.getMobileNumber());
            customerRepository.save(customer);
            return "Customer added successfully";
        }
        catch(Exception e){
            return "Customer was not added; because: "+e.getMessage();
        }
    }

    public Object getCustomer(Integer id){
        try{
            Optional<Customer> customer = customerRepository.findById(id);
            if(customer.isPresent()){
                return customer.get();
            }
            else{
                return "Customer "+id+" doesn't exist.";
            }
        }
        catch(Exception e){
            log.info(e.getMessage());
            return "Could not get customer "+id+"; because "+e.getMessage();
        }       
    }

    public String updateCustomer(Integer id, CustomerDetails customerDetails){
        try{
            Optional<Customer> customer = customerRepository.findById(id);
            if(customer.isPresent()){
                Customer cust = customer.get();
                cust.setName(customerDetails.getName());
                cust.setDob(customerDetails.getDob());
                cust.setAddress(customerDetails.getAddress());
                cust.setMobileNumber(customerDetails.getMobileNumber());
                customerRepository.save(cust);
                return "Customer "+id+" is updated successfully";
            }
            else{
                return "Customer "+id+" doesn't exist";
            }
        }
        catch(Exception e){
            return "Customer "+id+" was not updated; because "+e.getMessage();
        }       
    }

    public String deleteCustomer(Integer id){
        try{
            customerRepository.deleteById(id);
            return "Customer "+id+" deleted successfully.";
        }
        catch(Exception e){
            return "Customer "+id+" was not deleted; because "+e.getMessage();
        }       
    }
}
