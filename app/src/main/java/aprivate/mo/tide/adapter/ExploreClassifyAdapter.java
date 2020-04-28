package aprivate.mo.tide.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Classify;
import privat.mo.tidelib.listener.OnItemClickListener;

/**
 * Created by Mo on 2020/3/10
 *
 * Explore页 "分类" 列表适配器
 */

public class ExploreClassifyAdapter extends RecyclerView.Adapter<ExploreClassifyAdapter.ExploreClassifyViewHolder> {

    private List<Classify> classifyList;

    private OnItemClickListener classifySelectedListener;

    /**
     * 初始化rv
     *
     * @param classifyList
     */
    public ExploreClassifyAdapter(List<Classify> classifyList) {
        this.classifyList = classifyList;
    }

    @NonNull
    @Override
    public ExploreClassifyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_explore_classify, viewGroup, false);
        ExploreClassifyViewHolder exploreClassifyViewHolder = new ExploreClassifyViewHolder(itemView);
        return exploreClassifyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ExploreClassifyViewHolder viewHolder, int i) {

        viewHolder.tvClassifyTitle.setText("# " + classifyList.get(i).getType());
        viewHolder.ivClassifyCover.setImageResource(classifyList.get(i).getCover());

        //绑定点击事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (classifySelectedListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    classifySelectedListener.onItemClick(position, viewHolder.itemView, viewHolder);
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
    public static class ExploreClassifyViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivClassifyCover;
        public TextView tvClassifyTitle;

        public ExploreClassifyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivClassifyCover = (ImageView) itemView.findViewById(R.id.iv_explore_classify_item_cover);
            tvClassifyTitle = (TextView) itemView.findViewById(R.id.tv_explore_classify_item_title);
        }
    }


    public void setOnSelectClickListener(OnItemClickListener itemClickListener) {
        this.classifySelectedListener = itemClickListener;
    }
}
