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
 * Created by Mo on 2020/3/18
 * <p>
 * 分类—活动
 */

public class ClassifyEventAdapter extends
    RecyclerView.Adapter<ClassifyEventAdapter.ClassifyEventViewHolder> {

  private List<Event> eventList;
  private Context context;

  /**
   * 构造rv
   *
   * @param eventList
   */
  public ClassifyEventAdapter(Context context, List<Event> eventList) {
    this.eventList = eventList;
    this.context = context;
  }

  @NonNull
  @Override
  public ClassifyEventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View itemView = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_classify_event, viewGroup, false);
    return new ClassifyEventViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull ClassifyEventViewHolder viewHolder, int i) {
    Glide.with(context)
        .load(R.drawable.img_drama)
        .into(viewHolder.ivCover);
  }

  @Override
  public int getItemCount() {
    return eventList == null ? 0 : eventList.size();
  }

  /**
   * 自定义ViewHolder
   */
  static class ClassifyEventViewHolder extends RecyclerView.ViewHolder {

    ImageView ivCover;

    ClassifyEventViewHolder(@NonNull View itemView) {
      super(itemView);
      ivCover = (ImageView) itemView.findViewById(R.id.iv_classify_event_cover);
    }
  }
}
