package com.project.appointmentapp.repositories;

import com.project.appointmentapp.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}
