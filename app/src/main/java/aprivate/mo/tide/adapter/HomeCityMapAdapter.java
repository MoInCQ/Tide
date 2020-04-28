package aprivate.mo.tide.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Event;

/**
 * Created by Mo on 2020/3/10
 *
 * Home页 "城市地图" 适配器
 */

public class HomeCityMapAdapter extends RecyclerView.Adapter<HomeCityMapAdapter.HomeCityMapViewHolder> {

    private List<Event> eventList;

    public HomeCityMapAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public HomeCityMapViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_home_city_map, viewGroup, false);
        HomeCityMapViewHolder viewHolder = new HomeCityMapViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeCityMapViewHolder homeCityMapViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return eventList == null ? 0 : eventList.size();
    }

    public static class HomeCityMapViewHolder extends RecyclerView.ViewHolder {
        public HomeCityMapViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
