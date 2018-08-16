package com.codylund.dagger2_example;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        WeatherApplicationModule.class,
        AndroidModule.class,
})
public interface WeatherApplicationComponent extends AndroidInjector<WeatherApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<WeatherApplication> {
    }
}
