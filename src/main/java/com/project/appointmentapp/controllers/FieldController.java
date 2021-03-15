package com.project.appointmentapp.controllers;

import com.project.appointmentapp.ExceptionHandler.ExcHandler;
import com.project.appointmentapp.entities.Field;
import com.project.appointmentapp.services.field.IFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/field")
@RequiredArgsConstructor
public class FieldController {

    private final IFieldService _fieldService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Field> getFields() {
        return _fieldService.findAll();
    }

    @RequestMapping(value = {"/{fieldId}"}, method = RequestMethod.GET)
    public ResponseEntity getFieldById(@PathVariable int fieldId) {
        return ResponseEntity.ok(_fieldService.findById(fieldId));
    }

    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public ResponseEntity saveField(@RequestBody Field field) {
        try {
            return ResponseEntity.ok(_fieldService.save(field));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @RequestMapping(value = {"/{fieldId}"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteField(@PathVariable int fieldId) {
        return ResponseEntity.ok(_fieldService.delete(fieldId));
    }

    @ExceptionHandler(value = {EmptyResultDataAccessException.class, NoSuchElementException.class})
    public ResponseEntity excHandler(RuntimeException e, HttpServletRequest httpServletRequest) {
        ExcHandler exceptionHandler = new ExcHandler();
        String endPoint = httpServletRequest.getRequestURI();
        String id = endPoint.split("/")[3];

        exceptionHandler.setMessage(id+" fieldId'li kayıt bulunamadı.");
        exceptionHandler.setEndPoint(endPoint);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionHandler);
    }

}
