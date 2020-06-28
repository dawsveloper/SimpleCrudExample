package com.projects.simplecrudapps.network.request;

import com.android.volley.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteDataRequest extends BaseRequest {

    private String dataId;

    public DeleteDataRequest(){
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
