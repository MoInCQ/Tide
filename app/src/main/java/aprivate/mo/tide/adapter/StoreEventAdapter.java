package aprivate.mo.tide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Event;

/**
 * Created by Mo on 2020/6/7
 */

public class StoreEventAdapter extends RecyclerView.Adapter<StoreEventAdapter.StoreEventViewHolder> {

    private List<Event> eventList;
    private Context context;

    public StoreEventAdapter(List<Event> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @NonNull
    @Override
    public StoreEventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_home_city_map, viewGroup, false);
        return new StoreEventViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return eventList == null ? 0 : eventList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull StoreEventViewHolder viewHolder, int i) {
        Glide.with(context)
                .load(R.drawable.img_exhibition)
                .into(viewHolder.ivCover);
    }

    static class StoreEventViewHolder extends RecyclerView.ViewHolder {

        ImageView ivCover;

        public StoreEventViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_home_city_map_item_cover);
        }

    }
}
