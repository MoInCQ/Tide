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
 * Created by Mo on 2020/3/18
 */

public class ClassifyStoreAdapter extends RecyclerView.Adapter<ClassifyStoreAdapter.ClassifyStoreViewHolder> {

    private List<Store> storeList;

    /**
     * 构造rv
     *
     * @param storeList
     */
    public ClassifyStoreAdapter(List<Store> storeList) {
        this.storeList = storeList;
    }

    @NonNull
    @Override
    public ClassifyStoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_classify_store, viewGroup, false);
        ClassifyStoreViewHolder viewHolder = new ClassifyStoreViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClassifyStoreViewHolder classifyStoreViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return storeList == null ? 0 : storeList.size();
    }

    /**
     * 自定义ViewHolder
     */
    public static class ClassifyStoreViewHolder extends RecyclerView.ViewHolder {
        public ClassifyStoreViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
