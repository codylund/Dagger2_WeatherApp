package com.codylund.dagger2_example.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.codylund.dagger2_example.viewcontrollers.IMainViewController;
import com.codylund.dagger2_example.R;

import javax.inject.Inject;
import javax.inject.Singleton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

@Singleton
public class MainActivity extends AppCompatActivity implements IMainView {

    @BindView(R.id.text) TextView temperatureView;
    @BindView(R.id.time) TextView timeView;

    @Inject
    IMainViewController mMainViewController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.refresh)
    public void refresh() {
        mMainViewController.refreshWeather();
    }

    @Override
    public void weatherRequestSucceeded(String temperature, String time) {
        temperatureView.setText(temperature);
        timeView.setText(time);
    }

    @Override
    public void weatherRequestFailed() {
        Toast.makeText(this, "Failed to get weather request.", Toast.LENGTH_LONG).show();
    }
}
