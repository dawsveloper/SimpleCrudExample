package com.projects.simplecrudapps.network.request;

import com.android.volley.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDataRequest extends BaseRequest{

    private String dataId;

    public UpdateDataRequest(){
        super();
        setMethod(Request.Method.POST);
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
