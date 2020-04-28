package aprivate.mo.tide.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Store;

/**
 * Created by Mo on 2020/3/10
 *
 * Home页 "精选店铺" 适配器
 */

public class HomeSelectedStoreAdpter extends RecyclerView.Adapter<HomeSelectedStoreAdpter.HomeSelectedStoreViewHolder> {

    private List<Store> storeList;

    /**
     * 构造rv
     *
     * @param storeList
     */
    public HomeSelectedStoreAdpter(List<Store> storeList) {
        this.storeList = storeList;
    }

    @NonNull
    @Override
    public HomeSelectedStoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_home_seleced_store, viewGroup, false);
        HomeSelectedStoreViewHolder viewHolder = new HomeSelectedStoreViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeSelectedStoreViewHolder homeSelectedStoreViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return storeList == null ? 0 : storeList.size();
    }


    /**
     * 自定义ViewHolder
     */
    public static class HomeSelectedStoreViewHolder extends RecyclerView.ViewHolder {
        public HomeSelectedStoreViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
