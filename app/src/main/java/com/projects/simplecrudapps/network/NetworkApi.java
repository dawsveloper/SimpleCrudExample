package com.projects.simplecrudapps.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.projects.simplecrudapps.network.request.ListDataRequest;
import com.projects.simplecrudapps.network.request.VolleyJsonRequestBuilder;

import org.json.JSONObject;

public class NetworkApi extends BaseNetworkAPI{

    public NetworkApi(Context context) {
        super(context);
    }

    @Override
    public void getData(Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener) {
        String url = getNetworkAPI("list");

        ListDataRequest baseRequest = new ListDataRequest();

        JSONObject requestJSON = baseRequest.generateJSONParameter();
        VolleyJsonRequestBuilder requestBuilder = new VolleyJsonRequestBuilder(Request.Method.GET, url, requestJSON, successListener, errorListener);
        VolleySingleton.getInstance().addToRequestQueue(requestBuilder, context);
    }
}
