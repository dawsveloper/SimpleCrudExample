package com.projects.simplecrudapps.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.projects.simplecrudapps.AppConfiguration;
import com.projects.simplecrudapps.models.DataModel;
import com.projects.simplecrudapps.network.INetworkAPI;
import com.projects.simplecrudapps.network.responses.ListDataResponse;

import java.util.ArrayList;
import java.util.List;

public class ListDataViewModel extends AndroidViewModel {

    private INetworkAPI networkAPI;

    public MutableLiveData<List<DataModel>> dataModelLiveData = new MutableLiveData<>();

    public ListDataViewModel(@NonNull Application application) {
        super(application);
        networkAPI = AppConfiguration.getInstance().getNetworkAPI(application);
    }

    public void getListData(){
        networkAPI.getData(
                response -> {
                    ListDataResponse dataResponse = new ListDataResponse(response);
                    if (dataResponse.isOk())
                        dataModelLiveData.postValue(dataResponse.getDataModelList());
                },
                error -> dataModelLiveData.postValue(new ArrayList<>())
        );
    }
}
