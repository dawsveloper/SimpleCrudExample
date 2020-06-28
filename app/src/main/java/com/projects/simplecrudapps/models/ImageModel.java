package com.projects.simplecrudapps.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageModel {
    private String imageName;
    private String url;

    public ImageModel(String imageName, String url){
        setImageName(imageName);
        setUrl(url);
    }
}
