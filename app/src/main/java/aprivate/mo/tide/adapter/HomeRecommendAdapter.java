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
 * Home页 "推荐栏" 适配器
 */

public class HomeRecommendAdapter extends RecyclerView.Adapter<HomeRecommendAdapter.HomeRecommendViewHolder> {

    private List<Event> eventList;


    /**
     * 构造rv
     *
     * @param eventList
     */
    public HomeRecommendAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public HomeRecommendViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_home_recommend, viewGroup, false);
        HomeRecommendViewHolder viewHolder = new HomeRecommendViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecommendViewHolder homeRecommendViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return eventList == null ? 0 : eventList.size();
    }

    /**
     * 自定义ViewHolder
     */
    public static class HomeRecommendViewHolder extends RecyclerView.ViewHolder {
        public HomeRecommendViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
