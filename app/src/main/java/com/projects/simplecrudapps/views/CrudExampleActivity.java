package com.projects.simplecrudapps.views;

import android.util.Log;

import androidx.lifecycle.ViewModelProviders;

import com.projects.simplecrudapps.R;
import com.projects.simplecrudapps.adapter.BaseRecyclerAdapter;
import com.projects.simplecrudapps.databinding.ActivityCurdExampleBinding;
import com.projects.simplecrudapps.databinding.ItemDataBinding;
import com.projects.simplecrudapps.models.DataModel;
import com.projects.simplecrudapps.viewmodels.ListDataViewModel;

import java.util.ArrayList;
import java.util.List;

public class CrudExampleActivity extends BaseActivity<ActivityCurdExampleBinding> {

    private ListDataViewModel listDataViewModel;
    private List<DataModel> dataModelList = new ArrayList<>();
    private BaseRecyclerAdapter<DataModel> dataModelAdapter;

    @Override
    protected int attachLayoutView() {
        return R.layout.activity_curd_example;
    }

    @Override
    protected void initData() {
        super.initData();
        listDataViewModel = ViewModelProviders.of(this).get(ListDataViewModel.class);
        listDataViewModel.getListData();
        listDataViewModel.dataModelLiveData.observe(this, listData -> {
            if (dataModelList.size() == 0){
                dataModelList = listData;
                dataModelAdapter.setMainData(dataModelList);
            }
        });

        dataModelAdapter = new BaseRecyclerAdapter<>(
                R.layout.item_data,
                ((holder, item) -> {
                    ItemDataBinding binding = (ItemDataBinding) holder.getLayoutBinding();
                    binding.setItemDataModel(item);
                })
        );
    }

    @Override
    protected void initLayout() {
        super.initLayout();

        binding.setAdapter(dataModelAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
