package com.project.appointmentapp.job;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.project.appointmentapp.entities.Weather;
import com.project.appointmentapp.repositories.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class WeatherJob {

    private final WeatherRepository _weatherRepository;

    @Scheduled(cron = "0 0 0/2 * * ?")
    public void cronWeather() throws UnirestException {

        HttpResponse<String> response = Unirest.get("https://api.collectapi.com/weather/getWeather?data.lang=tr&data.city=sivas")
                .header("content-type", "application/json")
                .header("authorization", "apikey 5irMWXlsVXyS29qN5MKNSJ:1lIPgJgHqWu2vL2I92Ldn6")
                .asString();

        _weatherRepository.deleteAll();

        Weather weather = new Weather();
        weather.setWeather(response.getBody());
        weather.setFetchDate(new Date().toLocaleString());

        _weatherRepository.save(weather);

    }
}
