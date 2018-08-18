package com.codylund.dagger2_example;

import com.codylund.dagger2_example.viewcontrollers.IMainViewController;
import com.codylund.dagger2_example.viewcontrollers.MainViewController;

import dagger.Module;
import dagger.Provides;

/**
 * Generalizes the controller for the view layer.
 */
@Module(includes = DataModule.class)
public class ControllerModule {
    @Provides
    static IMainViewController providesIMainViewController(MainViewController mainViewController) {
        return mainViewController;
    }
}
