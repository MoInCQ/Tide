package aprivate.mo.tide.ui.add;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import aprivate.mo.tide.R;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/1/27
 */

public class AddFragment extends BaseFragment<IAddFragmentView, AddFragmentPresenter>
        implements IAddFragmentView {


    private AppBarLayout abl;
    private TextView tvTitle;
    private static final int TOOLBAR_HEIGHT_OFFSET = -450;



    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        abl = (AppBarLayout) view.findViewById(R.id.abl_add);
        tvTitle = (TextView) view.findViewById(R.id.tv_add_title);
        abl.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i < TOOLBAR_HEIGHT_OFFSET) {
                    tvTitle.setTextColor(Color.BLACK);
                } else {
                    tvTitle.setTextColor(Color.WHITE);
                }
            }
        });


    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_add;
    }

    @Override
    protected AddFragmentPresenter createPresenter() {
        return new AddFragmentPresenter();
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

    public static AddFragment newInstance() {
        return new AddFragment();
    }
}
