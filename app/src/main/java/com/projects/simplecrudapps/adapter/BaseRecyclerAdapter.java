package com.projects.simplecrudapps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BaseRecyclerAdapter<M> extends RecyclerView.Adapter<BaseRecyclerAdapter.SimpleViewHolder> {

    protected List<M> mainData;
    private BaseRecyclerAdapter.OnViewHolder<M> listener;
    private @LayoutRes
    int layoutRes;

    public BaseRecyclerAdapter(List<M> mainData, int layoutRes, BaseRecyclerAdapter.OnViewHolder<M> listener){
        this.mainData = mainData;
        this.listener = listener;
        this.layoutRes = layoutRes;
    }
    public BaseRecyclerAdapter(int layoutRes, BaseRecyclerAdapter.OnViewHolder<M> listener){
        this.listener = listener;
        this.layoutRes = layoutRes;
    }

    public interface OnViewHolder<T>{
        void onBindView(SimpleViewHolder holder, T item);
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{

        private BaseRecyclerAdapter.OnViewHolder listener;
        private ViewDataBinding layoutBinding;

        public SimpleViewHolder(@NonNull View itemView, BaseRecyclerAdapter.OnViewHolder listener) {
            super(itemView);

            try {
                this.listener = listener;
                layoutBinding = DataBindingUtil.bind(itemView);
            } catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }

        public ViewDataBinding getLayoutBinding() {
            return layoutBinding;
        }
    }

    @NonNull
    @Override
    public BaseRecyclerAdapter.SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(), parent, false);
        return new SimpleViewHolder(view, getListener());
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        M m = mainData.get(position);
        getListener().onBindView(holder, m);
    }

    @Override
    public int getItemCount() {
        return getMainData() == null ? 0 : getMainData().size();
    }

    public void setListener(OnViewHolder<M> listener) {
        this.listener = listener;
    }

    public OnViewHolder<M> getListener() {
        return listener;
    }

    public void setLayoutRes(int layoutRes) {
        this.layoutRes = layoutRes;
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    public void setMainData(List<M> mainData) {
        this.mainData = mainData;
        notifyDataSetChanged();
    }

    public List<M> getMainData() {
        return mainData;
    }

    public M getItemAt(int position){
        return this.mainData.get(position);
    }

    public void addItemAt(final M data, int position){
        getMainData().add(position, data);
        notifyItemInserted(position);
    }

    public void addItem(final M data){
        addItemAt(data, getMainData().size());
    }

    public void addAllItem(final List<M> dataList){
        getMainData().addAll(dataList);
        notifyDataSetChanged();
    }

    public void removeItem(final M data){
        getMainData().remove(data);
        notifyDataSetChanged();
    }

    public void removeItemAt(int position){
        getMainData().remove(position);
        notifyItemRemoved(position);
    }

    public void removeAll(){
        getMainData().clear();
        notifyDataSetChanged();
    }
}
