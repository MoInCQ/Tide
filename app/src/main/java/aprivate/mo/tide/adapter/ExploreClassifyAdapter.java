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
import aprivate.mo.tide.entity.Classify;
import com.bumptech.glide.Glide;
import java.util.List;
import privat.mo.tidelib.listener.OnItemClickListener;

/**
 * Created by Mo on 2020/3/10
 * <p>
 * Explore页 "分类" 列表适配器
 */

public class ExploreClassifyAdapter extends
    RecyclerView.Adapter<ExploreClassifyAdapter.ExploreClassifyViewHolder> {

  private List<Classify> classifyList;
  private Context context;

  private OnItemClickListener classifySelectedListener;

  /**
   * 初始化rv
   *
   * @param classifyList
   */
  public ExploreClassifyAdapter(Context context, List<Classify> classifyList) {
    this.context = context;
    this.classifyList = classifyList;
  }

  @NonNull
  @Override
  public ExploreClassifyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View itemView = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_explore_classify, viewGroup, false);
    return new ExploreClassifyViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull final ExploreClassifyViewHolder viewHolder, int i) {

    viewHolder.tvClassifyTitle.setText("# " + classifyList.get(i).getType());
    Glide.with(context)
        .load(classifyList.get(i).getCover())
        .into(viewHolder.ivClassifyCover);

    //绑定点击事件
    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (classifySelectedListener != null) {
          classifySelectedListener.onItemClick(viewHolder.getAdapterPosition()
                  , viewHolder.itemView, viewHolder);
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    return classifyList == null ? 0 : classifyList.size();
  }


  /**
   * 自定义ViewHolder
   */
  static class ExploreClassifyViewHolder extends RecyclerView.ViewHolder {

    ImageView ivClassifyCover;
    TextView tvClassifyTitle;

    ExploreClassifyViewHolder(@NonNull View itemView) {
      super(itemView);
      ivClassifyCover = (ImageView) itemView.findViewById(R.id.iv_explore_classify_item_cover);
      tvClassifyTitle = (TextView) itemView.findViewById(R.id.tv_explore_classify_item_title);
    }
  }


  public void setOnSelectClickListener(OnItemClickListener itemClickListener) {
    this.classifySelectedListener = itemClickListener;
  }
}
