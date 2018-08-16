package com.codylund.dagger2_example.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.codylund.dagger2_example.weather.IWeatherRequest;

import org.json.JSONObject;

import javax.inject.Inject;

public class VolleyNetworkModule implements INetworkModule {

    private static final String TAG = VolleyNetworkModule.class.getName();

    RequestQueue requestQueue;

    @Inject
    public VolleyNetworkModule(Context context) {
        Log.d(TAG, "Providing VolleyNetworkModule");
        requestQueue = Volley.newRequestQueue(context);
        requestQueue.start();
    }

    public void getJSON(final IJSONNetworkRequest request, final INetworkModuleResponse callback) {
        Log.d(TAG, "Sending new weather request.");
        requestQueue.add(new JsonObjectRequest(Request.Method.GET, request.getURL(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "Received new weather request: " + response.toString());
                request.parseResponse(response);
                callback.onSuccess();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO log the error
                callback.onFailure();
            }
        }).setShouldCache(false));
    }
}
