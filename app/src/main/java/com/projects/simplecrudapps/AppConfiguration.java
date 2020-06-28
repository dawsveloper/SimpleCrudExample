package com.projects.simplecrudapps;

import android.content.Context;

import com.projects.simplecrudapps.BuildConfig;
import com.projects.simplecrudapps.helper.JSONFileHelper;
import com.projects.simplecrudapps.network.BaseNetworkAPI;
import com.projects.simplecrudapps.network.NetworkApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class AppConfiguration {

    private static final AppConfiguration instance = new AppConfiguration();

    public static AppConfiguration getInstance() {
        return instance;
    }

    public BaseNetworkAPI getNetworkAPI(Context context){
        return new NetworkApi(context);
    }

    public JSONObject getApiUrls(Context context){
        Integer networkAPIUrl = BuildConfig.END_POINT;

        try {
            return JSONFileHelper.getInstance().readJsonFromResource(context, networkAPIUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getBaseUrl(){
        return BuildConfig.BASE_URL;
    }
}
