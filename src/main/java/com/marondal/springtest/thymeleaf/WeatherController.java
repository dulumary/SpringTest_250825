package com.marondal.springtest.thymeleaf;

import com.marondal.springtest.thymeleaf.domain.Weather;
import com.marondal.springtest.thymeleaf.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/list")
    public String weatherHistory(Model model) {
        // 과거 날씨 내역 얻어 오기
        List<Weather> weatherHistory = weatherService.getWeatherHistory();

        model.addAttribute("weatherHistory", weatherHistory);

        return "thymeleaf/weather/list";
    }

    @GetMapping("/form")
    public String weatherForm() {
        return "thymeleaf/weather/form";
    }


    @ResponseBody
    @GetMapping("/add")
    public String addWeather(
            @RequestParam("weather") String weather
            , @RequestParam("date") String date
            , @RequestParam("temperatures") double temperatures
            , @RequestParam("precipitation") double precipitation
            , @RequestParam("microDust") String microDust
            , @RequestParam("windSpeed") double windSpeed) {

        int count = weatherService.createWeather(weather, date, temperatures, precipitation, microDust, windSpeed);

        return "날씨 추가 : " + count;
    }

}
