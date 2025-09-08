package com.marondal.springtest.thymeleaf.repository;

import com.marondal.springtest.thymeleaf.domain.Weather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WeatherRepository {

    public List<Weather> selectWeatherHistory();

    public int insertWeather(
            @Param("weather") String weather
            , @Param("date") String date
            , @Param("temperatures") double temperatures
            , @Param("precipitation") double precipitation
            , @Param("microDust") String microDust
            , @Param("windSpeed") double windSpeed);
}
