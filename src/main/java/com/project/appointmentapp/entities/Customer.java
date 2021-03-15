package com.project.appointmentapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="customers")
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cusId;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Appointment> appointments;

    private Date crdt;

    public Customer(int cusId, String name, String surname, String username, String email, String phone, List<Appointment> appointments, Date crdt) {
        this.cusId = cusId;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.appointments = appointments;
        this.crdt = crdt;
    }

    public Customer() { }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Date getCrdt() {
        return crdt;
    }

    public void setCrdt(Date crdt) {
        this.crdt = crdt;
    }
}
