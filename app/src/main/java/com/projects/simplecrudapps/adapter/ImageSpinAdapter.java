package com.projects.simplecrudapps.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.projects.simplecrudapps.models.ImageModel;

import java.util.List;

public class ImageSpinAdapter extends ArrayAdapter<ImageModel> {

    private Context context;
    private List<ImageModel> values;

    public ImageSpinAdapter(@NonNull Context context, int resource, @NonNull List<ImageModel> objects) {
        super(context, resource, objects);

        this.context = context;
        this.values = objects;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Nullable
    @Override
    public ImageModel getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(values.get(position).getImageName());

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(values.get(position).getImageName());

        return label;
    }
}
