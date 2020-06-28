package com.projects.simplecrudapps.network.request;

import com.android.volley.Request;

public class ListDataRequest extends BaseRequest {

    public ListDataRequest(){
        super();
        setMethod(Request.Method.GET);
    }

    @Override
    protected String getAction() {
        return null;
    }

    @Override
    protected void populateParameters() {

    }
}
