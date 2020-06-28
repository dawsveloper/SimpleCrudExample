package com.projects.simplecrudapps.network.request;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class VolleyJsonRequestBuilder extends JsonObjectRequest {

    private JSONObject jsonParameters;
    private int mMethod = 0;

    public VolleyJsonRequestBuilder(int method, String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);

        this.jsonParameters = jsonRequest;
        mMethod = method;
    }
}
