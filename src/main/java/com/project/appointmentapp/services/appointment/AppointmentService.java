package com.project.appointmentapp.services.appointment;

import com.project.appointmentapp.dataaccess.appointment.IAppointmentDal;
import com.project.appointmentapp.dto.customer.AppointmentRequest;
import com.project.appointmentapp.entities.Appointment;
import com.project.appointmentapp.entities.Customer;
import com.project.appointmentapp.entities.Field;
import com.project.appointmentapp.services.customer.ICustomerService;
import com.project.appointmentapp.services.field.IFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService implements IAppointmentService {

    private final IAppointmentDal dal;
    private final ICustomerService customerService;
    private final IFieldService fieldService;

    @Override
    public List<Appointment> findAll() {
        return dal.findAll();
    }

    @Override
    public Appointment findById(int appId) {
        return dal.findById(appId);
    }

    @Override
    public Appointment save(Appointment appointment) {
        if(appointment.getAppId() > 0){
            Field field = fieldService.findById(appointment.getField().getFieldId());
            Customer customer = customerService.findById(appointment.getCustomer().getCusId());
            Appointment existAppointment = findById(appointment.getAppId());
            existAppointment.setCustomer(customer);
            existAppointment.setField(field);
            existAppointment.setBegdt(appointment.getBegdt());
            existAppointment.setEnddt(appointment.getEnddt());
            return dal.save(existAppointment);
        } else return dal.save(appointment);
    }

    @Override
    public int delete(int appId) {
        return dal.delete(appId);
    }
}
