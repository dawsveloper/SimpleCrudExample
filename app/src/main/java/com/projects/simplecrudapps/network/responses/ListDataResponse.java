package com.projects.simplecrudapps.network.responses;

import com.projects.simplecrudapps.models.DataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListDataResponse extends BaseResponse {

    private List<DataModel> dataModelList = new ArrayList<>();

    public ListDataResponse(JSONObject responseObject) {
        super(responseObject);

        if (isOk()){
            try {
                JSONArray dataModelArray = responseObject.getJSONArray("generatorList");
                for (int i = 0; i < dataModelArray.length(); i++){
                    JSONObject dataModelObject = dataModelArray.getJSONObject(i);
                    DataModel dataModel = new DataModel(dataModelObject);

                    dataModelList.add(dataModel);
                }
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
    }

    public List<DataModel> getDataModelList() {
        return dataModelList;
    }
}
