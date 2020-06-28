package com.projects.simplecrudapps.views;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<Binding extends ViewDataBinding> extends AppCompatActivity {

    protected Binding binding;
    abstract protected int attachLayoutView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        initLayout();
    }

    protected void initData(){
        binding = DataBindingUtil.setContentView(this, attachLayoutView());
    }

    protected void initLayout(){}
}
