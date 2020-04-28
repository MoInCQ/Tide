package aprivate.mo.tide.ui.personalcenter.root;

import android.view.View;

import aprivate.mo.tide.R;
import aprivate.mo.tide.ui.personalcenter.PersonalCenterFragment;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/3/17
 */

public class PersonalCenterRootFragment extends BaseFragment<IPersonalCenterRootFragmentView, PersonalCenterRootFragmentPresenter>
        implements IPersonalCenterRootFragmentView {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_personal_center_root;
    }

    public static PersonalCenterRootFragment newInstance() {
        return new PersonalCenterRootFragment();
    }

    @Override
    protected PersonalCenterRootFragmentPresenter createPresenter() {
        return new PersonalCenterRootFragmentPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        loadRootFragment(R.id.fl_personal_center_root_container, PersonalCenterFragment.newInstance());
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
