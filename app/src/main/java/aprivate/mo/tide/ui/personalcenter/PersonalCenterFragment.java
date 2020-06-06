package aprivate.mo.tide.ui.personalcenter;

import android.view.View;
import android.widget.RelativeLayout;

import aprivate.mo.tide.R;
import aprivate.mo.tide.ui.personalcenter.profile.PersonalProfileFragment;
import aprivate.mo.tide.utils.TideMessage;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/1/27
 */

public class PersonalCenterFragment extends BaseFragment<IPersonalCenterFragmentView, PersonalFragmentPresenter>
        implements IPersonalCenterFragmentView, View.OnClickListener {

    private RelativeLayout rlLogout;
    private RelativeLayout rlProfile;
    private RelativeLayout rlCollection;
    private RelativeLayout rlQRCode;
    private RelativeLayout rlFootPrint;

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
        rlLogout = (RelativeLayout) view.findViewById(R.id.rl_personal_center_logout);
        rlLogout.setOnClickListener(this);
        rlProfile = (RelativeLayout) view.findViewById(R.id.rl_personal_center_profile);
        rlProfile.setOnClickListener(this);
        rlCollection = (RelativeLayout) view.findViewById(R.id.rl_personal_center_collect);
        rlCollection.setOnClickListener(this);
        rlQRCode = (RelativeLayout) view.findViewById(R.id.rl_personal_center_qrcode);
        rlQRCode.setOnClickListener(this);
        rlFootPrint = (RelativeLayout) view.findViewById(R.id.rl_personal_center_footprint);
        rlFootPrint.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_personal_center_logout:
                getActivity().finish();
                break;
            case R.id.rl_personal_center_profile:
                start(PersonalProfileFragment.newInstance());
                break;
            case R.id.rl_personal_center_collect:
                TideMessage.showMessage("开发中，敬请期待");
                break;
            case R.id.rl_personal_center_qrcode:
                TideMessage.showMessage("开发中，敬请期待");
                break;
            case R.id.rl_personal_center_footprint:
                TideMessage.showMessage("开发中，敬请期待");
                break;
                default:
        }
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
