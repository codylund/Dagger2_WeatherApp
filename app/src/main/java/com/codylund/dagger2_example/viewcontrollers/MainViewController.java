package com.codylund.dagger2_example.viewcontrollers;

import android.util.Log;

import com.codylund.dagger2_example.network.INetworkModule;
import com.codylund.dagger2_example.network.INetworkModuleResponse;
import com.codylund.dagger2_example.views.IMainView;
import com.codylund.dagger2_example.weather.IWeatherRequest;
import com.codylund.dagger2_example.weather.IWeatherRequestFactory;

import javax.inject.Inject;

public class MainViewController implements IMainViewController {

    private static final String TAG = MainViewController.class.getName();

    @Inject
    IWeatherRequestFactory mWeatherRequestFactory;

    @Inject
    INetworkModule mNetworkModule;

    @Inject
    IMainView mMainView;

    @Inject
    public MainViewController() {
    }

    public void refreshWeather() {
        // Get a new weather request.
        final IWeatherRequest weatherRequest = mWeatherRequestFactory.getTemperatureWeatherRequest("0","0");

        // Send the weather request.
        mNetworkModule.getJSON(weatherRequest, new INetworkModuleResponse() {
            @Override
            public void onSuccess() {
                // Process the successful weather request.
                if (weatherRequest.hasResponse()) {
                    Log.d(TAG, weatherRequest.getData());
                    mMainView.weatherRequestSucceeded(weatherRequest.getData() + " F", weatherRequest.getTime());
                }
            }

            @Override
            public void onFailure() {
                // Process the failed weather request
                Log.w(TAG, "Failed to get weather data...");
                mMainView.weatherRequestFailed();
            }
        });
    }
}
