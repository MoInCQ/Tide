package privat.mo.tidelib.listener;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Mo on 2020/3/17
 */

public interface OnItemClickListener {

    void onItemClick(int position, View view, RecyclerView.ViewHolder viewHolder);

    void onItemLongClickListener(int position, View view, RecyclerView.ViewHolder viewHolder);
}
