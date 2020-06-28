package com.projects.simplecrudapps.network;

import android.content.Context;

import com.android.volley.Response;
import com.projects.simplecrudapps.network.request.DataDetailRequest;
import com.projects.simplecrudapps.network.request.DeleteDataRequest;
import com.projects.simplecrudapps.network.request.InsertDataRequest;
import com.projects.simplecrudapps.network.request.ListDataRequest;
import com.projects.simplecrudapps.network.request.UpdateDataRequest;
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
        VolleyJsonRequestBuilder requestBuilder = new VolleyJsonRequestBuilder(baseRequest.getMethod(), url, requestJSON, successListener, errorListener);
        VolleySingleton.getInstance().addToRequestQueue(requestBuilder, context);
    }

    @Override
    public void getDataDetail(String dataId, Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener) {
        String url = getNetworkAPI("detail");

        DataDetailRequest baseRequest = new DataDetailRequest();
        baseRequest.setDataId(dataId);

        JSONObject requestJSON = baseRequest.generateJSONParameter();
        VolleyJsonRequestBuilder requestBuilder = new VolleyJsonRequestBuilder(baseRequest.getMethod(), url, requestJSON, successListener, errorListener);
        VolleySingleton.getInstance().addToRequestQueue(requestBuilder, context);
    }

    @Override
    public void insertData(String dataId, Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener) {
        String url = getNetworkAPI("insert");

        InsertDataRequest baseRequest = new InsertDataRequest();
        baseRequest.setDataId(dataId);

        JSONObject requestJSON = baseRequest.generateJSONParameter();
        VolleyJsonRequestBuilder requestBuilder = new VolleyJsonRequestBuilder(baseRequest.getMethod(), url, requestJSON, successListener, errorListener);
        VolleySingleton.getInstance().addToRequestQueue(requestBuilder, context);
    }

    @Override
    public void updateData(String dataId, Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener) {
        String url = getNetworkAPI("update");

        UpdateDataRequest baseRequest = new UpdateDataRequest();
        baseRequest.setDataId(dataId);

        JSONObject requestJSON = baseRequest.generateJSONParameter();
        VolleyJsonRequestBuilder requestBuilder = new VolleyJsonRequestBuilder(baseRequest.getMethod(), url, requestJSON, successListener, errorListener);
        VolleySingleton.getInstance().addToRequestQueue(requestBuilder, context);
    }

    @Override
    public void deleteData(String dataId, Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener) {
        String url = getNetworkAPI("delete");

        DeleteDataRequest baseRequest = new DeleteDataRequest();
        baseRequest.setDataId(dataId);

        JSONObject requestJSON = baseRequest.generateJSONParameter();
        VolleyJsonRequestBuilder requestBuilder = new VolleyJsonRequestBuilder(baseRequest.getMethod(), url, requestJSON, successListener, errorListener);
        VolleySingleton.getInstance().addToRequestQueue(requestBuilder, context);
    }
}
