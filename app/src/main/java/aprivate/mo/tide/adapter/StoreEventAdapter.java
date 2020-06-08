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
import privat.mo.tidelib.listener.OnItemClickListener;

/**
 * Created by Mo on 2020/6/7
 */

public class StoreEventAdapter extends RecyclerView.Adapter<StoreEventAdapter.StoreEventViewHolder> {

    private List<Event> eventList;
    private Context context;

    private OnItemClickListener onItemClickListener;

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
                .load(eventList.get(i).getCover())
                .into(viewHolder.ivCover);
        viewHolder.tvTitle.setText(eventList.get(i).getTitle() + " | " + eventList.get(i).getSubTitle());
        viewHolder.tvIntro.setText(eventList.get(i).getIntro());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(i, v, viewHolder);
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    static class StoreEventViewHolder extends RecyclerView.ViewHolder {

        ImageView ivCover;
        TextView tvTitle;
        TextView tvIntro;

        public StoreEventViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_home_city_map_item_cover);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_home_city_map_item_title);
            tvIntro = (TextView) itemView.findViewById(R.id.tv_home_city_map_item_intro);
        }

    }
}
