package com.codylund.dagger2_example;

import com.codylund.dagger2_example.views.IMainView;
import com.codylund.dagger2_example.views.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module(includes = ControllerModule.class)
public class ViewModule {

    private static final String TAG = ViewModule.class.getName();

    @Provides
    static IMainView providesMainView(MainActivity mainActivity) {
        return mainActivity;
    }
}
