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
 * Created by Mo on 2020/3/11
 *
 * Message页 "通知" 列表
 */

public class MessageNotificationAdapter extends RecyclerView.Adapter<MessageNotificationAdapter.MessageNotificationViewHolder> {

    private List<Event> eventList;

    /**
     * 构造rv
     *
     * @param eventList
     */
    public MessageNotificationAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public MessageNotificationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_message_notification, viewGroup, false);
        MessageNotificationViewHolder viewHolder = new MessageNotificationViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageNotificationViewHolder messageNotificationViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return eventList == null ? 0 : eventList.size();
    }

    /**
     * 自定义ViewHolder
     */
    public static class MessageNotificationViewHolder extends RecyclerView.ViewHolder {
        public MessageNotificationViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
