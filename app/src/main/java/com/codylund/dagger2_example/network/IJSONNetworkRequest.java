package com.codylund.dagger2_example.network;

import org.json.JSONObject;

public interface IJSONNetworkRequest {
    String getURL();
    void parseResponse(JSONObject jsonObject);
    boolean hasResponse();
}
