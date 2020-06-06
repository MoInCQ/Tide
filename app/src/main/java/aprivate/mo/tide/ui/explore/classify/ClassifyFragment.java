package aprivate.mo.tide.ui.explore.classify;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.adapter.ClassifyEventAdapter;
import aprivate.mo.tide.adapter.ClassifyStoreAdapter;
import aprivate.mo.tide.entity.Classify;
import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.entity.Store;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/3/17
 */

public class ClassifyFragment extends BaseFragment<IClassifyFragmentView, ClassifyFragmentPresenter> implements IClassifyFragmentView {

    /**
     * 获取索引数据初始化
     */
    private static final String ARG_ITEM = "arg_item";
    private Classify mClassify;

    /**
     * 顶部栏
     */
    private ImageView ivCover;
    private TextView tvTitle;
    private Toolbar toolbar;
    private ImageView ivBack;

    /**
     * 店铺相关
     */
    private RecyclerView rvStore;
    private ClassifyStoreAdapter classifyStoreAdapter;
    private LinearLayoutManager classifyStoreLayoutManager;

    /**
     * 活动相关
     */
    private RecyclerView rvEvent;
    private ClassifyEventAdapter classifyEventAdapter;
    private LinearLayoutManager classifyEventLayoutManager;


    @Override
    protected void initData() {
        getPresenter().getStoreList();
        getPresenter().getEventList();
    }

    @Override
    protected void initView(View view) {
        //获取索引数据初始化
        if (getArguments().getParcelable(ARG_ITEM) == null) {
            pop();
        }
        mClassify = getArguments().getParcelable(ARG_ITEM);

        //顶部栏
        ivCover = (ImageView) view.findViewById(R.id.iv_classify_cover);
        tvTitle = (TextView) view.findViewById(R.id.tv_classify_title);
        toolbar = (Toolbar) view.findViewById(R.id.tb_classify);
        ivBack = (ImageView) view.findViewById(R.id.iv_classify_tb_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });

        ivCover.setImageResource(mClassify.getCover());
        tvTitle.setText("# " + mClassify.getType());


        //店铺
        rvStore = (RecyclerView) view.findViewById(R.id.rv_classify_store);

        //活动
        rvEvent = (RecyclerView) view.findViewById(R.id.rv_classify_event);

    }

    /**
     * 初始化店铺信息
     *
     * @param storeList
     */
    @Override
    public void initStoreList(List<Store> storeList) {
        classifyStoreLayoutManager = new LinearLayoutManager(getContext());
        classifyStoreLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        classifyStoreAdapter = new ClassifyStoreAdapter(getContext(), storeList);
        rvStore.setLayoutManager(classifyStoreLayoutManager);
        rvStore.setAdapter(classifyStoreAdapter);
    }


    /**
     * 初始化活动信息
     *
     * @param eventList
     */
    @Override
    public void initEventList(List<Event> eventList) {
        classifyEventLayoutManager = new LinearLayoutManager(getContext());
        classifyEventLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        classifyEventAdapter = new ClassifyEventAdapter(getContext(), eventList);
        rvEvent.setLayoutManager(classifyEventLayoutManager);
        rvEvent.setAdapter(classifyEventAdapter);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_classify;
    }

    @Override
    protected ClassifyFragmentPresenter createPresenter() {
        return new ClassifyFragmentPresenter();
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

    public static ClassifyFragment newInstance(Classify classify) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_ITEM, classify);
        ClassifyFragment classifyFragment = new ClassifyFragment();
        classifyFragment.setArguments(args);
        return classifyFragment;
    }

}
