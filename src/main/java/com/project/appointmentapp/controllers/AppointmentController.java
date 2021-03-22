package com.project.appointmentapp.controllers;

import com.project.appointmentapp.ExceptionHandler.ExcHandler;
import com.project.appointmentapp.entities.Appointment;
import com.project.appointmentapp.repositories.WeatherRepository;
import com.project.appointmentapp.services.appointment.IAppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppointmentController {

    public final IAppointmentService _service;

    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String test() {
        return "test2";
    }

    // /api/appointment
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Appointment> getAppointments() {
        return _service.findAll();
    }

    // /api/appointment/3
    @RequestMapping(value = {"/{appId}"}, method = RequestMethod.GET)
    public ResponseEntity getAppointment(@PathVariable int appId) {
        return ResponseEntity.ok(_service.findById(appId));
    }

    // /api/appointment
    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public ResponseEntity saveAppointment(@RequestBody Appointment appointment) {
        try {
            return ResponseEntity.ok(_service.save(appointment));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FOUND).body(e.getMessage());
        }
    }

    // /api/appointment/5
    @RequestMapping(value = {"/{appId}"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteAppointment(@PathVariable int appId) {
        return ResponseEntity.ok(_service.delete(appId));
    }

    @ExceptionHandler(value = {EmptyResultDataAccessException.class, NoSuchElementException.class})
    public ResponseEntity excHandler(RuntimeException e, HttpServletRequest httpServletRequest) {
        ExcHandler exceptionHandler = new ExcHandler();
        String endPoint = httpServletRequest.getRequestURI();
        String id = endPoint.split("/")[3];

        exceptionHandler.setMessage(id + " appId'li kayıt bulunamadı.");
        exceptionHandler.setEndPoint(endPoint);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionHandler);
    }

}
