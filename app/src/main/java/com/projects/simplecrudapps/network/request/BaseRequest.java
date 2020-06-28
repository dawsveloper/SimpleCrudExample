package com.projects.simplecrudapps.network.request;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class BaseRequest {
    protected Map<String, Object> parameters;
    protected abstract String getAction();
    protected abstract void populateParameters();
    protected int method;

    public BaseRequest() {
        parameters = new HashMap<>();
    }

    public JSONObject generateJSONParameter(){
        populateParameters();

        JSONObject parameter = new JSONObject();
        try {
            if (getAction() != null && getAction().length() > 0) {
                parameter.put("action", getAction());
            }

            Set<Map.Entry<String, Object>> entries = parameters.entrySet();
            for(Map.Entry<String, Object> entry : entries) {
                if (entry.getValue() != null) {
                    parameter.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parameter;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }
}
