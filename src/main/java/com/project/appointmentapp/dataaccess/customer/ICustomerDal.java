package com.project.appointmentapp.dataaccess.customer;

import com.project.appointmentapp.entities.Appointment;
import com.project.appointmentapp.entities.Customer;

import java.util.List;

public interface ICustomerDal {

    List<Customer> findAll();
    Customer findById(int cusId);
    Customer save(Customer customer);
    Customer delete(Customer customer);
}
