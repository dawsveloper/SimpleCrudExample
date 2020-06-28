package com.projects.simplecrudapps.views;

import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.projects.simplecrudapps.R;
import com.projects.simplecrudapps.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private boolean pressedOnce = false;

    @Override
    protected int attachLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initLayout() {
        super.initLayout();

        binding.btnWidget.setOnClickListener(v -> startActivity(new Intent(this, WidgetExampleActivity.class)));
        binding.btnCrud.setOnClickListener(v -> startActivity(new Intent(this, CrudExampleActivity.class)));
    }

    @Override
    public void onBackPressed() {
        if (pressedOnce){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        this.pressedOnce = true;
        Toast.makeText(this, getString(R.string.warning_press_once_to_exit), Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(() -> pressedOnce = false, 1500);
    }
}