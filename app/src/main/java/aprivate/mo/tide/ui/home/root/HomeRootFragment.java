package aprivate.mo.tide.ui.home.root;

import android.view.View;

import aprivate.mo.tide.R;
import aprivate.mo.tide.ui.home.HomeFragment;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/3/17
 */

public class HomeRootFragment extends BaseFragment<IHomeRootFragmentView, HomeRootFragmentPresenter> implements IHomeRootFragmentView {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home_root;
    }

    public static HomeRootFragment newInstance() {
        return new HomeRootFragment();
    }
    @Override
    protected HomeRootFragmentPresenter createPresenter() {
        return new HomeRootFragmentPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        loadRootFragment(R.id.fl_home_root_container, HomeFragment.newInstance());
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
}
