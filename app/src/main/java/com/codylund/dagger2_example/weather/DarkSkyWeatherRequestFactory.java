package com.codylund.dagger2_example.weather;

import android.content.Context;
import android.util.Log;

import com.codylund.dagger2_example.R;

import javax.inject.Inject;

public class DarkSkyWeatherRequestFactory implements IWeatherRequestFactory {

    private static final String TAG = DarkSkyWeatherRequestFactory.class.getName();
    private static final String BASE_URL = "https://api.darksky.net/forecast/";

    @Inject
    Context mContext;

    @Inject
    public DarkSkyWeatherRequestFactory() {
        Log.d(TAG, "Providing WeatherRequestFactory");
    }

    @Override
    public IWeatherRequest getTemperatureWeatherRequest(String lat, String lng) {
        return new DarkSkyTemperatureWeatherRequest(BASE_URL + getApiKey() + "/" + lat + "," + lng);
    }

    private String getApiKey() {
        return this.mContext.getResources().getString(R.string.dark_sky_api_key);
    }

}
