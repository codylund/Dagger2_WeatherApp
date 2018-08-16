package com.codylund.dagger2_example;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {
    @Provides
    Context providesContext(WeatherApplication weatherApplication) {
        return weatherApplication.getApplicationContext();
    }
}
