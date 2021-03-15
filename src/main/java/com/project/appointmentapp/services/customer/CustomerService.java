package com.project.appointmentapp.services.customer;

import com.project.appointmentapp.dataaccess.customer.ICustomerDal;
import com.project.appointmentapp.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService{

    private final ICustomerDal dal;

    @Override
    public List<Customer> findAll() {
        return dal.findAll();
    }

    @Override
    public Customer findById(int cusId) {
        return dal.findById(cusId);
    }

    @Override
    public Customer save(Customer customer) {
        long cusId = customer.getCusId();
        if(cusId > 0L){
            Customer existCustomer = findById(customer.getCusId());
            existCustomer.setPhone(customer.getPhone());
            return dal.save(existCustomer);
        }
        else {
            return dal.save(customer);
        }
    }

    @Override
    public Customer delete(Customer customer) {
        return dal.delete(customer);
    }
}
