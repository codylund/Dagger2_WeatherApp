package com.codylund.dagger2_example;

import com.codylund.dagger2_example.views.MainActivity;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

@Module(includes = AndroidInjectionModule.class)
public abstract class WeatherApplicationModule {
    @ContributesAndroidInjector(modules = {ViewModule.class})
    abstract MainActivity contributeActivityInjector();
}
