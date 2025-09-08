package com.marondal.springtest.thymeleaf.service;

import com.marondal.springtest.thymeleaf.domain.Weather;
import com.marondal.springtest.thymeleaf.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    //  과거 날씨 내역 얻어오기
    public List<Weather> getWeatherHistory() {
        List<Weather> weatherHistory = weatherRepository.selectWeatherHistory();

        return weatherHistory;
    }

    public int createWeather(
            String weather
            , LocalDate date
            , double temperatures
            , double precipitation
            , String microDust
            , double windSpeed) {

        int count = weatherRepository.insertWeather(weather, date, temperatures, precipitation, microDust, windSpeed);

        return count;
    }

    public int createWeatherByObject(Weather weather) {
        int count = weatherRepository.insertWeatherByObject(weather);
        return count;
    }

}
