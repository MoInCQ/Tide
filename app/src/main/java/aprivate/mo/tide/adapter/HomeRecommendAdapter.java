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
 * Home页 "推荐栏" 适配器
 */

public class HomeRecommendAdapter extends
    RecyclerView.Adapter<HomeRecommendAdapter.HomeRecommendViewHolder> {

  private List<Event> eventList;
  private Context context;

  /**
   * 构造rv
   *
   * @param eventList
   */
  public HomeRecommendAdapter(Context context, List<Event> eventList) {
    this.context = context;
    this.eventList = eventList;
  }

  @NonNull
  @Override
  public HomeRecommendViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View itemView = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_home_recommend, viewGroup, false);
    return new HomeRecommendViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull HomeRecommendViewHolder viewHolder, int i) {
    Glide.with(context)
        .load(R.drawable.img_recommend)
        .into(viewHolder.ivCover);
  }

  @Override
  public int getItemCount() {
    return eventList == null ? 0 : eventList.size();
  }

  /**
   * 自定义ViewHolder
   */
  static class HomeRecommendViewHolder extends RecyclerView.ViewHolder {

    ImageView ivCover;

    HomeRecommendViewHolder(@NonNull View itemView) {
      super(itemView);
      ivCover = (ImageView) itemView.findViewById(R.id.iv_home_recommend_item_cover);
    }
  }
}
