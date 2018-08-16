package com.codylund.dagger2_example;

import com.codylund.dagger2_example.network.INetworkModule;
import com.codylund.dagger2_example.network.VolleyNetworkModule;
import com.codylund.dagger2_example.weather.DarkSkyWeatherRequestFactory;
import com.codylund.dagger2_example.weather.IWeatherRequestFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    private static final String TAG = DataModule.class.getName();

    @Provides
    static IWeatherRequestFactory providesWeatherRequestFactory(DarkSkyWeatherRequestFactory darkSkyWeatherRequestFactory) {
        return darkSkyWeatherRequestFactory;
    }

    @Provides
    static INetworkModule providesNetworkModule(VolleyNetworkModule volleyNetworkModule) {
        return volleyNetworkModule;
    }
}
