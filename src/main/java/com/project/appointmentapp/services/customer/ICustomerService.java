package com.project.appointmentapp.services.customer;

import com.project.appointmentapp.entities.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
    Customer findById(int cusId);
    Customer save(Customer customer);
    Customer delete(Customer customer);
}
