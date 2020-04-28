package aprivate.mo.tide.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.CitySelected;

/**
 * Created by Mo on 2020/3/9
 *
 * 侧边栏 "城市选择" 适配器
 */

public class DrawerSelectCityAdapter extends RecyclerView.Adapter<DrawerSelectCityAdapter.CitySelectedViewHolder> {

    private List<CitySelected> citySelectedList;


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
    public DrawerSelectCityAdapter(List<CitySelected> citySelectedList) {
        this.citySelectedList = citySelectedList;
    }

    @NonNull
    @Override
    public CitySelectedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_main_drawer_select_city, viewGroup, false);
        CitySelectedViewHolder viewHolder = new CitySelectedViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CitySelectedViewHolder viewHolder, final int i) {
        viewHolder.tvCityName.setText(citySelectedList.get(i).getName());

        //绑定点击事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null) {
                    onItemClickListener.onItemClick(viewHolder.itemView, i);
                }
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemLongClick(viewHolder.itemView,i);
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
    public static class CitySelectedViewHolder extends RecyclerView.ViewHolder {

        public TextView tvCityName;

        public CitySelectedViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCityName = (TextView) itemView.findViewById(R.id.tv_drawer_main_rv_select_city_name);
        }
    }




}
