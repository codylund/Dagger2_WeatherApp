package com.codylund.dagger2_example.weather;

public interface IWeatherRequestFactory {
    IWeatherRequest getTemperatureWeatherRequest(String lat, String lng);
}
