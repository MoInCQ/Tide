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
 * Created by Mo on 2020/3/10
 * <p>
 * Home页 "精选店铺" 适配器
 */

public class HomeSelectedStoreAdpter extends
    RecyclerView.Adapter<HomeSelectedStoreAdpter.HomeSelectedStoreViewHolder> {

  private List<Store> storeList;
  private Context context;

  private OnItemClickListener mItemClickListener;


  /**
   * 构造rv
   */
  public HomeSelectedStoreAdpter(Context context, List<Store> storeList) {
    this.context = context;
    this.storeList = storeList;
  }

  @NonNull
  @Override
  public HomeSelectedStoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View itemView = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_home_seleced_store, viewGroup, false);
    return new HomeSelectedStoreViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull HomeSelectedStoreViewHolder viewHolder, int i) {

    Glide.with(context)
        .load(storeList.get(i).getCover())
        .into(viewHolder.civCover);
    viewHolder.tvName.setText(storeList.get(i).getName());
    viewHolder.tvCity.setText(storeList.get(i).getCity());


    // 绑定点击事件
    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (mItemClickListener != null) {
          mItemClickListener.onItemClick(viewHolder.getAdapterPosition()
                  , viewHolder.itemView, viewHolder);
        }
      }
    });
  }

  public void setOnSelectedStoreClickListener(OnItemClickListener onItemClickListener) {
    this.mItemClickListener = onItemClickListener;
  }

  @Override
  public int getItemCount() {
    return storeList == null ? 0 : storeList.size();
  }


  /**
   * 自定义ViewHolder
   */
  static class HomeSelectedStoreViewHolder extends RecyclerView.ViewHolder {

    CircleImageView civCover;
    TextView tvName;
    TextView tvCity;

    HomeSelectedStoreViewHolder(@NonNull View itemView) {
      super(itemView);
      civCover = (CircleImageView) itemView.findViewById(R.id.civ_home_selected_store_item_cover);
      tvName = (TextView) itemView.findViewById(R.id.tv_home_selected_store_item_name);
      tvCity = (TextView) itemView.findViewById(R.id.tv_home_selected_store_item_city);
    }
  }
}
