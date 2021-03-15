package com.project.appointmentapp.repositories;

import com.project.appointmentapp.entities.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Integer> {
}
