package aprivate.mo.tide.ui.explore.root;

import android.view.View;

import aprivate.mo.tide.R;
import aprivate.mo.tide.ui.explore.ExploreFragment;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/3/17
 */

public class ExploreRootFragment extends BaseFragment<IExploreRootFragmentView, ExploreRootFragmentPresenter> implements IExploreRootFragmentView {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_explore_root;
    }

    public static ExploreRootFragment newInstance() {
        return new ExploreRootFragment();
    }

    @Override
    protected ExploreRootFragmentPresenter createPresenter() {
        return new ExploreRootFragmentPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        loadRootFragment(R.id.fl_explore_root_container, ExploreFragment.newInstance());
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
