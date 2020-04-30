package aprivate.mo.tide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Event;
import com.bumptech.glide.Glide;
import java.util.List;

/**
 * Created by Mo on 2020/3/10
 * <p>
 * Home页 "城市地图" 适配器
 */

public class HomeCityMapAdapter extends
    RecyclerView.Adapter<HomeCityMapAdapter.HomeCityMapViewHolder> {

  private List<Event> eventList;
  private Context context;

  public HomeCityMapAdapter(Context context, List<Event> eventList) {
    this.eventList = eventList;
    this.context = context;
  }

  @NonNull
  @Override
  public HomeCityMapViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View itemView = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_home_city_map, viewGroup, false);
    return new HomeCityMapViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull HomeCityMapViewHolder viewHolder, int i) {
    Glide.with(context)
        .load(R.drawable.img_movie)
        .into(viewHolder.ivCover);
  }

  @Override
  public int getItemCount() {
    return eventList == null ? 0 : eventList.size();
  }

  static class HomeCityMapViewHolder extends RecyclerView.ViewHolder {

    ImageView ivCover;

    HomeCityMapViewHolder(@NonNull View itemView) {
      super(itemView);
      ivCover = (ImageView) itemView.findViewById(R.id.iv_home_city_map_item_cover);
    }
  }
}
