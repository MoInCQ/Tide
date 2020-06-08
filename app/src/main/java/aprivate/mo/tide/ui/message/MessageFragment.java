package aprivate.mo.tide.ui.message;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.adapter.MessageNotificationAdapter;
import aprivate.mo.tide.ui.home.event.EventFragment;
import privat.mo.tidelib.base.BaseFragment;
import privat.mo.tidelib.listener.OnItemClickListener;

/**
 * Created by Mo on 2020/1/27
 */

public class MessageFragment extends BaseFragment<IMessageFragmentView, MessageFragmentPresenter>
        implements IMessageFragmentView {


    private RecyclerView rvNotification;
    private MessageNotificationAdapter messageNotificationAdapter;
    private LinearLayoutManager messageNotificationLayoutManager;

    @Override
    protected void initData() {
        getPresenter().getNotificationList();
    }

    @Override
    protected void initView(View view) {
        rvNotification = (RecyclerView) view.findViewById(R.id.rv_notification);
    }

    /**
     * 初始化 "通知" 列表
     */
    @Override
    public void initNotificationList(List<Event> events) {
        messageNotificationAdapter = new MessageNotificationAdapter(getContext(), events);
        messageNotificationLayoutManager = new LinearLayoutManager(getContext());
        messageNotificationLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        messageNotificationAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder viewHolder) {
                start(EventFragment.newInstance(events.get(position)));
            }

            @Override
            public void onItemLongClickListener(int position, View view, RecyclerView.ViewHolder viewHolder) {

            }
        });
        rvNotification.setAdapter(messageNotificationAdapter);
        rvNotification.setLayoutManager(messageNotificationLayoutManager);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_message;
    }

    @Override
    protected MessageFragmentPresenter createPresenter() {
        return new MessageFragmentPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String tip) {

    }

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }
}
