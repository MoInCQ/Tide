package aprivate.mo.tide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
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
 * Created by Mo on 2020/3/18
 * <p>
 * 分类—活动
 */

public class ClassifyEventAdapter extends
    RecyclerView.Adapter<ClassifyEventAdapter.ClassifyEventViewHolder> {

  private List<Event> eventList;
  private Context context;

  private OnItemClickListener onItemClickListener;

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
    Event event = eventList.get(i);
    Glide.with(context)
            .load(event.getCover())
            .into(viewHolder.ivCover);
    viewHolder.tvTitle.setText(event.getTitle() + " | " + event.getSubTitle());
    viewHolder.tvIntro.setText(event.getIntro());
    viewHolder.tvTime.setText(event.getDate() + " —— " + event.getTime());
    viewHolder.tvAddress.setText(event.getSponsor() + " —— " + event.getAddress());
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
  static class ClassifyEventViewHolder extends RecyclerView.ViewHolder {

    ImageView ivCover;
    TextView tvTitle;
    TextView tvIntro;
    TextView tvTime;
    TextView tvAddress;
    TextView tvPopulation;
    TextView tvFares;

    ClassifyEventViewHolder(@NonNull View itemView) {
      super(itemView);
      ivCover = (ImageView) itemView.findViewById(R.id.iv_classify_event_cover);
      tvTitle = (TextView) itemView.findViewById(R.id.tv_classify_event_title);
      tvIntro = (TextView) itemView.findViewById(R.id.tv_classify_event_brief_info);
      tvTime = (TextView) itemView.findViewById(R.id.tv_classify_event_time);
      tvAddress = (TextView) itemView.findViewById(R.id.tv_classify_event_address);
      tvPopulation = (TextView) itemView.findViewById(R.id.tv_classify_event_population);
      tvFares = (TextView) itemView.findViewById(R.id.tv_classify_event_fee);

    }
  }
}
