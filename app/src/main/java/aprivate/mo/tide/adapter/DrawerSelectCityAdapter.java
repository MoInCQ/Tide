package aprivate.mo.tide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.CitySelected;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

/**
 * Created by Mo on 2020/3/9
 * <p>
 * 侧边栏 "城市选择" 适配器
 */

public class DrawerSelectCityAdapter extends
    RecyclerView.Adapter<DrawerSelectCityAdapter.CitySelectedViewHolder> {

  private List<CitySelected> citySelectedList;
  private Context context;


  /**
   * 设置点击事件监听
   */
  public interface OnCitySelectedClickListener {

    void onItemClick(View view, int position);

    void onItemLongClick(View view, int position);
  }

  private DrawerSelectCityAdapter.OnCitySelectedClickListener onItemClickListener;

  public void setOnItemClickListener(DrawerSelectCityAdapter.OnCitySelectedClickListener listener) {
    this.onItemClickListener = listener;
  }


  /**
   * 构造rv
   *
   * @param citySelectedList
   */
  public DrawerSelectCityAdapter(Context context, List<CitySelected> citySelectedList) {
    this.context = context;
    this.citySelectedList = citySelectedList;
  }

  @NonNull
  @Override
  public CitySelectedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View itemView = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_main_drawer_select_city, viewGroup, false);
    return new CitySelectedViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull final CitySelectedViewHolder viewHolder, final int i) {
    viewHolder.tvCityName.setText(citySelectedList.get(i).getName());
    Glide.with(context)
        .load(R.drawable.img_city)
        .into(viewHolder.civCityCover);

    //绑定点击事件
    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (onItemClickListener != null) {
          onItemClickListener.onItemClick(viewHolder.itemView, i);
        }
      }
    });

    viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View v) {
        if (onItemClickListener != null) {
          onItemClickListener.onItemLongClick(viewHolder.itemView, i);
        }
        return true;
      }
    });
  }

  @Override
  public int getItemCount() {
    return citySelectedList == null ? 0 : citySelectedList.size();
  }


  /**
   * 自定义ViewHolder
   */
  static class CitySelectedViewHolder extends RecyclerView.ViewHolder {

    TextView tvCityName;
    CircleImageView civCityCover;

    CitySelectedViewHolder(@NonNull View itemView) {
      super(itemView);
      tvCityName = (TextView) itemView.findViewById(R.id.tv_drawer_main_rv_select_city_name);
      civCityCover = (CircleImageView) itemView.findViewById(R.id.civ_drawer_main_select_city);
    }
  }


}
