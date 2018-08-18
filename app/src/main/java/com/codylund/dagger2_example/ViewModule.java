package com.codylund.dagger2_example;

import android.support.v7.app.ActionBar;

import com.codylund.dagger2_example.views.IMainView;
import com.codylund.dagger2_example.views.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Generalizes the view layer for the view controller.
 */
@Module(includes = ControllerModule.class)
public class ViewModule {

    /**
     * Provides the generalized main activity.
     * @param mainActivity
     * @return the generalized main activity
     */
    @Provides
    static IMainView providesMainView(MainActivity mainActivity) {
        return mainActivity;
    }

    /**
     * Provides the action bar.
     * @param mainActivity
     * @return the action bar
     */
    @Provides
    ActionBar providesActionBar(MainActivity mainActivity) {
        return mainActivity.getSupportActionBar();
    }
}
