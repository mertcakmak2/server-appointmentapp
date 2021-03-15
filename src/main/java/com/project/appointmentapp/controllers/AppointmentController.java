package com.project.appointmentapp.controllers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.project.appointmentapp.ExceptionHandler.ExcHandler;
import com.project.appointmentapp.entities.Appointment;
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
public class AppointmentController {

    public final IAppointmentService _service;

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

    @RequestMapping(value = {"/weather"}, method = RequestMethod.GET)
    public String getAkaryakit() throws UnirestException {
        /*HttpResponse<String> response = Unirest.get("https://api.collectapi.com/corona/countriesData?country=Turkey")
                .header("content-type", "application/json")
                .header("authorization", "apikey 5irMWXlsVXyS29qN5MKNSJ:1lIPgJgHqWu2vL2I92Ldn6")
                .asString();
        return response.getBody();*/

        HttpResponse<String> response = Unirest.get("https://api.collectapi.com/weather/getWeather?data.lang=tr&data.city=ankara")
                .header("content-type", "application/json")
                .header("authorization", "apikey 5irMWXlsVXyS29qN5MKNSJ:1lIPgJgHqWu2vL2I92Ldn6")
                .asString();

        return response.getBody();
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
