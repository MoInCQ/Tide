package aprivate.mo.tide.ui.home.store;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.adapter.StoreEventAdapter;
import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.entity.Store;
import aprivate.mo.tide.ui.home.event.EventFragment;
import aprivate.mo.tide.widget.TideTitleBar;
import privat.mo.tidelib.base.BaseFragment;
import privat.mo.tidelib.listener.OnItemClickListener;

/**
 * Created by Mo on 2020/6/6
 */

public class StoreFragment extends BaseFragment<IStoreFragmentView, StoreFragmentPresenter>
        implements IStoreFragmentView {

    /**
     * 获取索引数据初始化
     */
    private static final String ARG_ITEM = "arg_item";
    private Store mStore;

    private TideTitleBar titleBar;
    private ImageView ivCover;
    private TextView tvAddress;
    private TextView tvIntro;

    private RecyclerView rvEvent;
    private StoreEventAdapter mEventAdapter;
    private LinearLayoutManager mEventLayoutManager;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_store;
    }

    @Override
    protected StoreFragmentPresenter createPresenter() {
        return new StoreFragmentPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        // 获取索引数据初始化
        if (getArguments().getParcelable(ARG_ITEM) == null) {
            pop();
        }
        mStore = getArguments().getParcelable(ARG_ITEM);

        titleBar = (TideTitleBar) view.findViewById(R.id.ttb_store);
        titleBar.setBackClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
        titleBar.setTitle(mStore.getName());

        // 店铺相关信息
        ivCover = (ImageView) view.findViewById(R.id.iv_store_cover);
        ivCover.setImageResource(mStore.getCover());
        tvAddress = (TextView) view.findViewById(R.id.tv_store_address);
        tvAddress.setText(mStore.getAddress());
        tvIntro = (TextView) view.findViewById(R.id.tv_store_intro);
        tvIntro.setText(mStore.getIntro());

        // 店铺相关活动列表
        rvEvent = (RecyclerView) view.findViewById(R.id.rv_store_event);
        getPresenter().getStoreEventList();

    }

    @Override
    public void initStoreEventList(List<Event> eventList) {

        mEventAdapter = new StoreEventAdapter(eventList, getContext());
        mEventLayoutManager = new LinearLayoutManager(getContext());
        mEventLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mEventAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder viewHolder) {
                start(EventFragment.newInstance(eventList.get(position)));
            }

            @Override
            public void onItemLongClickListener(int position, View view, RecyclerView.ViewHolder viewHolder) {

            }
        });
        rvEvent.setLayoutManager(mEventLayoutManager);
        rvEvent.setAdapter(mEventAdapter);

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

    public static StoreFragment newInstance(Store store) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_ITEM, store);
        StoreFragment storeFragment = new StoreFragment();
        storeFragment.setArguments(args);
        return storeFragment;
    }


}
