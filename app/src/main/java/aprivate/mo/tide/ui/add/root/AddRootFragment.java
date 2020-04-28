package aprivate.mo.tide.ui.add.root;

import android.view.View;

import aprivate.mo.tide.R;
import aprivate.mo.tide.ui.add.AddFragment;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/3/17
 */

public class AddRootFragment extends BaseFragment<IAddRootFragmentView, AddRootFragmentPresenter> implements IAddRootFragmentView {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_add_root;
    }

    public static AddRootFragment newInstance() {
        return new AddRootFragment();
    }

    @Override
    protected AddRootFragmentPresenter createPresenter() {
        return new AddRootFragmentPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        loadRootFragment(R.id.fl_add_root_container, AddFragment.newInstance());
    }
}
