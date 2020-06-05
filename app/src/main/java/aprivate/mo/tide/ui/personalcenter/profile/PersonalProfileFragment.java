package aprivate.mo.tide.ui.personalcenter.profile;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.adapter.PersonalProfileAdapter;
import aprivate.mo.tide.entity.ProfileItem;
import aprivate.mo.tide.entity.TideUser;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/6/4
 */

public class PersonalProfileFragment extends BaseFragment<IPersonalProfileFragmentView, PersonalProfileFragmentPresenter>
        implements IPersonalProfileFragmentView, View.OnClickListener {

    private ImageView ivBack;
    private RecyclerView rvProfile;
    private PersonalProfileAdapter mProfileAdpter;
    private LinearLayoutManager mProfileLayoutManager;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_personal_profile;
    }

    @Override
    protected PersonalProfileFragmentPresenter createPresenter() {
        return new PersonalProfileFragmentPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        ivBack = (ImageView) view.findViewById(R.id.iv_back);
        ivBack.setOnClickListener(this);
        rvProfile = (RecyclerView) view.findViewById(R.id.rv_personal_profile);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                pop();
                break;
                default:
        }
    }


    @Subscribe(sticky = true)
    public void onCheckPersonalProfile(TideUser user) {
        getPresenter().getPersonalProfileList(user);
    }


    /**
     * 初始化用户个人资料列表
     *
     * @param profileItems
     */
    @Override
    public void initPersonalProfileList(List<ProfileItem> profileItems) {
        mProfileAdpter = new PersonalProfileAdapter(profileItems);
        mProfileLayoutManager = new LinearLayoutManager(getContext());
        mProfileLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rvProfile.setAdapter(mProfileAdpter);
        rvProfile.setLayoutManager(mProfileLayoutManager);
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

    public static PersonalProfileFragment newInstance() {
        return new PersonalProfileFragment();
    }
}
