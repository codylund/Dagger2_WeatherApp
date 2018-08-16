package com.codylund.dagger2_example.network;

public interface INetworkModule {
    void getJSON(IJSONNetworkRequest request, final INetworkModuleResponse callback);
}