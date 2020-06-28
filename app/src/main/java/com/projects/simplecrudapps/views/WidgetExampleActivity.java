package com.projects.simplecrudapps.views;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.projects.simplecrudapps.R;
import com.projects.simplecrudapps.adapter.ImageSpinAdapter;
import com.projects.simplecrudapps.databinding.ActivityWidgetExampleBinding;
import com.projects.simplecrudapps.models.ImageModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class WidgetExampleActivity extends BaseActivity<ActivityWidgetExampleBinding> {

    private List<ImageModel> imageModelList = new ArrayList<>();
    private ArrayAdapter<ImageModel> imageModelAdapter;

    @Override
    protected int attachLayoutView() {
        return R.layout.activity_widget_example;
    }

    @Override
    protected void initData() {
        super.initData();

        imageModelList.add(new ImageModel("dota 2", "https://steamcdn-a.akamaihd.net/steam/apps/570/header.jpg?t=1591047995"));
        imageModelList.add(new ImageModel("Mobile Legend", "https://i.pinimg.com/564x/4d/ff/51/4dff5187487c05e5742b4139209789cd.jpg"));
        imageModelList.add(new ImageModel("PUBG", "https://wallpapercave.com/wp/wp3278776.jpg"));

        imageModelAdapter = new ImageSpinAdapter(this, android.R.layout.simple_spinner_item, imageModelList);
    }

    @Override
    protected void initLayout() {
        super.initLayout();

        binding.imgPicker.setAdapter(imageModelAdapter);
        binding.imgPicker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageModel image = imageModelAdapter.getItem(position);
                showProgressImage(true);
                Picasso.get().load(image.getUrl())
                        .into(binding.imgView, new Callback() {
                            @Override
                            public void onSuccess() {
                                showProgressImage(false);
                            }

                            @Override
                            public void onError(Exception e) {
                                showProgressImage(false);
                                Toast.makeText(getApplicationContext(), "Error loading image", Toast.LENGTH_SHORT).show();
                            }
                        });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void showProgressImage(boolean show){
        if (show){
            binding.imgProgress.setVisibility(View.VISIBLE);
            binding.imgView.setVisibility(View.GONE);
        }
        else {
            binding.imgProgress.setVisibility(View.GONE);
            binding.imgView.setVisibility(View.VISIBLE);
        }
    }
}
