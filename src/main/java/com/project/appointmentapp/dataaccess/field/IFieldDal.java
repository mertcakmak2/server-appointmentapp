package com.project.appointmentapp.dataaccess.field;

import com.project.appointmentapp.entities.Customer;
import com.project.appointmentapp.entities.Field;

import java.util.List;

public interface IFieldDal {

    List<Field> findAll();
    Field findById(int fieldId);
    Field save(Field field);
    int delete(int fieldId);
}
