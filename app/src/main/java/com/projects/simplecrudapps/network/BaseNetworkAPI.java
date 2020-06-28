package com.projects.simplecrudapps.network;

import android.content.Context;

import com.projects.simplecrudapps.AppConfiguration;
import com.projects.simplecrudapps.helper.JSONFileHelper;

import org.json.JSONObject;

public abstract class BaseNetworkAPI implements INetworkAPI{

    protected Context context;

    public BaseNetworkAPI(Context context) {
        this.context = context;
    }

    protected String getNetworkAPI(String apiName){
        JSONObject urlResourceObject = AppConfiguration.getInstance().getApiUrls(context);
        String baseUrl = AppConfiguration.getInstance().getBaseUrl();
        String endPoint = JSONFileHelper.getInstance().readString(urlResourceObject, apiName);

        return baseUrl + endPoint;
    }
}
