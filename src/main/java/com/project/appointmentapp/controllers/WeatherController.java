package com.project.appointmentapp.controllers;

import com.project.appointmentapp.entities.Weather;
import com.project.appointmentapp.repositories.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WeatherController {

    private final WeatherRepository _weatherRepository;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Weather> getWeather(){
        return _weatherRepository.findAll();
    }
}
