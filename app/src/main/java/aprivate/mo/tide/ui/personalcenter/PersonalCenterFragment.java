package aprivate.mo.tide.ui.personalcenter;

import android.view.View;

import aprivate.mo.tide.R;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/1/27
 */

public class PersonalCenterFragment extends BaseFragment<IPersonalCenterFragmentView, PersonalFragmentPresenter>
        implements IPersonalCenterFragmentView {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_personal_center;
    }

    @Override
    protected PersonalFragmentPresenter createPresenter() {
        return new PersonalFragmentPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

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

    public static PersonalCenterFragment newInstance() {
        return new PersonalCenterFragment();
    }
}
