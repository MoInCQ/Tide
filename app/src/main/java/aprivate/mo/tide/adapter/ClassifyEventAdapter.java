package aprivate.mo.tide.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Event;

/**
 * Created by Mo on 2020/3/18
 */

public class ClassifyEventAdapter extends RecyclerView.Adapter<ClassifyEventAdapter.ClassifyEventViewHolder> {

    private List<Event> eventList;

    /**
     * 构造rv
     *
     * @param eventList
     */
    public ClassifyEventAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public ClassifyEventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_classify_event, viewGroup, false);
        ClassifyEventViewHolder viewHolder = new ClassifyEventViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClassifyEventViewHolder classifyEventViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return eventList == null ? 0 : eventList.size();
    }

    /**
     * 自定义ViewHolder
     */
    public static class ClassifyEventViewHolder extends RecyclerView.ViewHolder {
        public ClassifyEventViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
