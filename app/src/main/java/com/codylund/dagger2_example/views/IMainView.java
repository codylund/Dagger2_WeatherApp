package com.codylund.dagger2_example.views;

public interface IMainView {
    void weatherRequestSucceeded(String temperature, String time);
    void weatherRequestFailed();
}
