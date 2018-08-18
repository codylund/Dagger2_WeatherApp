package com.codylund.dagger2_example;

import android.content.Context;
import android.support.v7.app.ActionBar;

import com.codylund.dagger2_example.views.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Provider for application-wide, Android-specfic objects.
 */
@Module
public class AndroidModule {
    @Provides
    Context providesContext(WeatherApplication weatherApplication) {
        return weatherApplication.getApplicationContext();
    }
}
