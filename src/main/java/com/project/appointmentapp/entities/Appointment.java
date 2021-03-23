package com.project.appointmentapp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointments")
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appId;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date begdt;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date enddt;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date crdt;

    public Appointment(int appId, Customer customer, Field field, Date begdt, Date enddt, Date crdt) {
        this.appId = appId;
        this.customer = customer;
        this.field = field;
        this.begdt = begdt;
        this.enddt = enddt;
        this.crdt = crdt;
    }

    public Appointment() {}

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Date getBegdt() {
        return begdt;
    }

    public void setBegdt(Date begdt) {
        this.begdt = begdt;
    }

    public Date getEnddt() {
        return enddt;
    }

    public void setEnddt(Date enddt) {
        this.enddt = enddt;
    }

    public Date getCrdt() {
        return crdt;
    }

    public void setCrdt(Date crdt) {
        this.crdt = crdt;
    }
}
