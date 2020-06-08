package aprivate.mo.tide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Event;
import privat.mo.tidelib.listener.OnItemClickListener;

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

  private OnItemClickListener onItemClickListener;

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
    Event event = eventList.get(i);
    Glide.with(context)
            .load(event.getCover())
            .into(viewHolder.ivCover);
    viewHolder.tvTitle.setText(event.getTitle());
    viewHolder.tvTime.setText(event.getDate());
    viewHolder.tvAddress.setText(event.getAddress());
    viewHolder.tvPopulation.setText(event.getRegisterPopulation() + " / " + event.getSupposedPopulation());
    viewHolder.tvPopulation.setText(event.getFares() + " 元 / 人");


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
  @Override
  public int getItemCount() {
    return eventList == null ? 0 : eventList.size();
  }

  /**
   * 自定义ViewHolder
   */
  static class MessageNotificationViewHolder extends RecyclerView.ViewHolder {

    ImageView ivCover;
    TextView tvTitle;
    TextView tvTime;
    TextView tvAddress;
    TextView tvPopulation;
    TextView tvFares;

    MessageNotificationViewHolder(@NonNull View itemView) {
      super(itemView);
      ivCover = (ImageView) itemView.findViewById(R.id.iv_message_notification_item_cover);
      tvTitle = (TextView) itemView.findViewById(R.id.tv_message_notification_item_title);
      tvTime = (TextView) itemView.findViewById(R.id.tv_message_notification_item_time);
      tvAddress = (TextView) itemView.findViewById(R.id.tv_message_notification_item_address);
      tvPopulation = (TextView) itemView.findViewById(R.id.tv_message_notification_item_population);
      tvFares = (TextView) itemView.findViewById(R.id.tv_message_notification_item_fee);
    }
  }
}
