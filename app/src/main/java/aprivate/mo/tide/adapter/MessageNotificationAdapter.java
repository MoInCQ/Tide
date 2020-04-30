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
 * Created by Mo on 2020/3/11
 * <p>
 * Message页 "通知" 列表
 */

public class MessageNotificationAdapter extends
    RecyclerView.Adapter<MessageNotificationAdapter.MessageNotificationViewHolder> {

  private List<Event> eventList;
  private Context context;

  /**
   * 构造rv
   *
   * @param eventList
   */
  public MessageNotificationAdapter(Context context, List<Event> eventList) {
    this.context = context;
    this.eventList = eventList;
  }

  @NonNull
  @Override
  public MessageNotificationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View itemView = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_message_notification, viewGroup, false);
    return new MessageNotificationViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull MessageNotificationViewHolder viewHolder, int i) {
    Glide.with(context)
        .load(R.drawable.img_exhibition)
        .into(viewHolder.ivCover);
  }

  @Override
  public int getItemCount() {
    return eventList == null ? 0 : eventList.size();
  }

  /**
   * 自定义ViewHolder
   */
  static class MessageNotificationViewHolder extends RecyclerView.ViewHolder {

    ImageView ivCover;

    MessageNotificationViewHolder(@NonNull View itemView) {
      super(itemView);
      ivCover = (ImageView) itemView.findViewById(R.id.iv_message_notification_item_cover);
    }
  }
}
