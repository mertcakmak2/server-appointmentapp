package com.project.appointmentapp.dto.customer;

import com.project.appointmentapp.entities.Customer;
import com.project.appointmentapp.entities.Field;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Data
public class AppointmentRequest {

    private long appId;
    private long customerId;
    private long fieldId;
    private Date begdt;
    private Date enddt;
    private Date crdt;
}
