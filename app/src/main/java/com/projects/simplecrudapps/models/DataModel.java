package com.projects.simplecrudapps.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataModel implements Parcelable {
    private String id;
    private String name;
    private String type;
    private String location;

    public DataModel(JSONObject responseObject){
        try {
            if (responseObject.has("id"))
                setId(responseObject.getString("id"));
            if (responseObject.has("name"))
                setName(responseObject.getString("name"));
            if (responseObject.has("type"))
                setType(responseObject.getString("type"));
            if (responseObject.has("location"))
                setLocation(responseObject.getString("location"));
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    protected DataModel(Parcel in) {
        id = in.readString();
        name = in.readString();
        type = in.readString();
        location = in.readString();
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(location);
    }
}
