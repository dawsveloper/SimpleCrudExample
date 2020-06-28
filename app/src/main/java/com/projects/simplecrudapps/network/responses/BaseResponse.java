package com.projects.simplecrudapps.network.responses;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseResponse {

    protected Integer status;
    protected String message;
    protected String rawResponse;

    public BaseResponse(JSONObject responseObject) {
        rawResponse = responseObject.toString();

        if (responseObject.has("responseCode"))
            status = responseObject.optInt("responseCode");
        else
            status = 200;

        message = responseObject.optString("message");
    }
    public boolean isOk() {
        return status == 200;
    }

    public String getMessage(){
        return message;
    }

    protected String readString(JSONObject jsonObject, String attributeName) {
        try {
            String attribute = jsonObject.getString(attributeName);
            return attribute;
        } catch (JSONException e) {
            return null;
        }
    }

    protected Integer readInteger(JSONObject jsonObject, String attributeName) {
        try {
            Integer attribute = jsonObject.getInt(attributeName);
            return attribute;
        } catch (JSONException e) {
            return null;
        }
    }

    protected Double readDouble(JSONObject jsonObject, String attributeName) {
        try {
            Double attribute = jsonObject.getDouble(attributeName);
            return attribute;
        } catch (JSONException e) {
            return null;
        }
    }

    protected Boolean readBoolean(JSONObject jsonObject, String attributeName) {
        try {
            Boolean attribute = jsonObject.getBoolean(attributeName);
            return attribute;
        } catch (JSONException e) {
            return null;
        }
    }

    protected JSONArray readJsonArray(JSONObject jsonObject, String attributeName) {
        try {
            return jsonObject.getJSONArray(attributeName);
        } catch (JSONException e) {
            return null;
        }
    }
}
