package com.project.appointmentapp.services.field;

import com.project.appointmentapp.entities.Field;

import java.util.List;

public interface IFieldService {

    List<Field> findAll();
    Field findById(int fieldId);
    Field save(Field field);
    int delete(int fieldId);
}
