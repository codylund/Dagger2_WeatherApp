package com.codylund.dagger2_example;

import com.codylund.dagger2_example.viewcontrollers.IMainViewController;
import com.codylund.dagger2_example.viewcontrollers.MainViewController;

import dagger.Module;
import dagger.Provides;

@Module(includes = DataModule.class)
public class ControllerModule {

    private static final String TAG = ControllerModule.class.getName();

    @Provides
    static IMainViewController providesIMainViewController(MainViewController mainViewController) {
        return mainViewController;
    }
}
