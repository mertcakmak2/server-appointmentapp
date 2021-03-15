package com.project.appointmentapp.dataaccess.customer;

import com.project.appointmentapp.entities.Customer;
import com.project.appointmentapp.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerDal implements ICustomerDal {

    private final CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(int cusId) {
        return repository.findById(cusId).get();
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer delete(Customer customer) {
        repository.delete(customer);
        return customer;
    }
}
