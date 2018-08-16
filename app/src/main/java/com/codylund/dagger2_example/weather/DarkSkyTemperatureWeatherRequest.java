package com.codylund.dagger2_example.weather;

import android.util.Log;

import com.codylund.dagger2_example.weather.IWeatherRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DarkSkyTemperatureWeatherRequest implements IWeatherRequest {

    private static final String TAG = DarkSkyTemperatureWeatherRequest.class.getName();

    private final String url;
    private String temperature = null;
    private String time = null;
    private final String title = "Temperature (F)";
    private boolean hasResponse = false;

    DarkSkyTemperatureWeatherRequest(String url) {
        this.url = url;
    }

    public String getURL() {
        return this.url;
    }

    public void parseResponse(JSONObject jsonObject) {
        try {
            // Get the temperature
            this.temperature = jsonObject.getJSONObject("currently").getString("temperature");

            // Get the time the temperature was recorded
            long timeInt = jsonObject.getJSONObject("currently").getLong("time");
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTimeInMillis(timeInt*1000);

            this.time = calendar.getTime().toString();

            Log.d(TAG, this.temperature + "@" + this.time);

            // We got a response!
            this.hasResponse = true;
        } catch (JSONException e) {
            // TODO log the occurence
        }
    }


    public boolean hasResponse() {
        return this.hasResponse;
    }

    @Override
    public String getTime() {
        return this.time;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getData() {
        return this.temperature;
    }
}
