package aprivate.mo.tide.ui.home.store;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Store;
import aprivate.mo.tide.widget.TideTitleBar;
import privat.mo.tidelib.base.BaseFragment;

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

        ivCover = (ImageView) view.findViewById(R.id.iv_store_cover);
        ivCover.setImageResource(mStore.getCover());
        tvAddress = (TextView) view.findViewById(R.id.tv_store_address);
        tvAddress.setText(mStore.getAddress());
        tvIntro = (TextView) view.findViewById(R.id.tv_store_intro);
        tvIntro.setText(mStore.getIntro());
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
