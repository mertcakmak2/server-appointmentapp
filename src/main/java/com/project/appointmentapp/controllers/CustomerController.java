package com.project.appointmentapp.controllers;

import com.project.appointmentapp.entities.Customer;
import com.project.appointmentapp.services.customer.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    private final ICustomerService service;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Customer> getCustomers(){
        return service.findAll();
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity getCustomer(@PathVariable int id){
        try{
            return ResponseEntity.ok(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public ResponseEntity saveCustomer(@RequestBody Customer customer){
        try{
            return ResponseEntity.ok(service.save(customer));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @RequestMapping(value = {""}, method = RequestMethod.DELETE)
    public ResponseEntity deleteCustomer(@RequestBody Customer customer){
        try{
            return ResponseEntity.ok(service.delete(customer));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
