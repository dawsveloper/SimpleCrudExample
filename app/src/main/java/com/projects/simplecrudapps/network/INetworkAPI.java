package com.projects.simplecrudapps.network;

import com.android.volley.Response;

import org.json.JSONObject;

public interface INetworkAPI {

    void getData(Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener);
}
