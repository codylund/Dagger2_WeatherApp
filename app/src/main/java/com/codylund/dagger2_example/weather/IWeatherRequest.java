package com.codylund.dagger2_example.weather;

import com.codylund.dagger2_example.network.IJSONNetworkRequest;

public interface IWeatherRequest extends IJSONNetworkRequest {
    String getTime();
    String getTitle();
    String getData();
}
