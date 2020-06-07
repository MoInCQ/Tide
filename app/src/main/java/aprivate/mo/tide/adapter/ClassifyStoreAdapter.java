package aprivate.mo.tide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Store;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import privat.mo.tidelib.listener.OnItemClickListener;

import java.util.List;

/**
 * Created by Mo on 2020/3/18
 */

public class ClassifyStoreAdapter extends
    RecyclerView.Adapter<ClassifyStoreAdapter.ClassifyStoreViewHolder> {

  private List<Store> storeList;
  private Context context;

  private OnItemClickListener onItemClickListener;

  /**
   * 构造rv
   *
   * @param storeList
   */
  public ClassifyStoreAdapter(Context context, List<Store> storeList) {
    this.context = context;
    this.storeList = storeList;
  }

  @NonNull
  @Override
  public ClassifyStoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View itemView = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_classify_store, viewGroup, false);
    return new ClassifyStoreViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull ClassifyStoreViewHolder viewHolder, int i) {
    Glide.with(context)
        .load(storeList.get(i).getCover())
        .into(viewHolder.civCover);
    viewHolder.tvName.setText(storeList.get(i).getName());
    viewHolder.tvCity.setText(storeList.get(i).getCity());

    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (onItemClickListener != null) {
          onItemClickListener.onItemClick(i, v, viewHolder);
        }
      }
    });

  }

  @Override
  public int getItemCount() {
    return storeList == null ? 0 : storeList.size();
  }

  public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    this.onItemClickListener = onItemClickListener;
  }

  /**
   * 自定义ViewHolder
   */
  static class ClassifyStoreViewHolder extends RecyclerView.ViewHolder {

    CircleImageView civCover;
    TextView tvName;
    TextView tvCity;

    ClassifyStoreViewHolder(@NonNull View itemView) {
      super(itemView);
      civCover = (CircleImageView) itemView.findViewById(R.id.civ_classify_store_item_cover);
      tvName = (TextView) itemView.findViewById(R.id.tv_classify_store_item_name);
      tvCity = (TextView) itemView.findViewById(R.id.tv_classify_store_item_city);

    }
  }
}
