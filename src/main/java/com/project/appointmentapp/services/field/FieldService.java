package com.project.appointmentapp.services.field;

import com.project.appointmentapp.dataaccess.field.IFieldDal;
import com.project.appointmentapp.entities.Field;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FieldService implements IFieldService {

    private final IFieldDal dal;

    @Override
    public List<Field> findAll() {
        return dal.findAll();
    }

    @Override
    public Field findById(int fieldId) {
        return dal.findById(fieldId);
    }

    @Override
    public Field save(Field field) {
        if (field.getFieldId() > 0) {
            Field existField = findById(field.getFieldId());
            existField.setFieldName(field.getFieldName());
            existField.setPrice(field.getPrice());
            return dal.save(existField);
        } else return dal.save(field);
    }

    @Override
    public int delete(int fieldId) {
        return dal.delete(fieldId);
    }
}
