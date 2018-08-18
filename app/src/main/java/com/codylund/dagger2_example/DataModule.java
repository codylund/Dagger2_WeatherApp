package com.codylund.dagger2_example;

import com.codylund.dagger2_example.network.INetworkModule;
import com.codylund.dagger2_example.network.VolleyNetworkModule;
import com.codylund.dagger2_example.weather.DarkSkyWeatherRequestFactory;
import com.codylund.dagger2_example.weather.IWeatherRequestFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Generalizes the data/util objects for the view controller.
 */
@Module
public class DataModule {
    @Provides
    static IWeatherRequestFactory providesWeatherRequestFactory(DarkSkyWeatherRequestFactory darkSkyWeatherRequestFactory) {
        return darkSkyWeatherRequestFactory;
    }

    @Provides
    static INetworkModule providesNetworkModule(VolleyNetworkModule volleyNetworkModule) {
        return volleyNetworkModule;
    }
}
