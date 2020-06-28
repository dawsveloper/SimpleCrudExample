package com.projects.simplecrudapps.network.request;

import com.android.volley.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataDetailRequest extends BaseRequest {

    private String dataId;

    public DataDetailRequest(){
        super();
        setMethod(Request.Method.GET);
    }

    @Override
    protected String getAction() {
        return null;
    }

    @Override
    protected void populateParameters() {
        parameters.put("dataId", getDataId());
    }
}
