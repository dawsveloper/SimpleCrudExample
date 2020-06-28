package com.projects.simplecrudapps.network;

import com.android.volley.Response;

import org.json.JSONObject;

public interface INetworkAPI {

    void getData(Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener);
    void getDataDetail(String dataId, Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener);
    void insertData(String dataId, Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener);
    void updateData(String dataId, Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener);
    void deleteData(String dataId, Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener);
}
