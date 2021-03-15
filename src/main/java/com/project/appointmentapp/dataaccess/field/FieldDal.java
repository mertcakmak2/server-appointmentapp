package com.project.appointmentapp.dataaccess.field;

import com.project.appointmentapp.entities.Field;
import com.project.appointmentapp.repositories.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FieldDal implements IFieldDal{

    private final FieldRepository repository;

    @Override
    public List<Field> findAll() {
        return repository.findAll();
    }

    @Override
    public Field findById(int fieldId) {
        return repository.findById(fieldId).get();
    }

    @Override
    public Field save(Field field) {
        return repository.save(field);
    }

    @Override
    public int delete(int fieldId) {
        repository.deleteById(fieldId);
        return fieldId;
    }
}
