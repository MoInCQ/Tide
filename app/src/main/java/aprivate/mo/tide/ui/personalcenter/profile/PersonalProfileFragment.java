package aprivate.mo.tide.ui.personalcenter.profile;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.adapter.PersonalProfileAdapter;
import aprivate.mo.tide.entity.ProfileItem;
import aprivate.mo.tide.entity.TideUser;
import aprivate.mo.tide.Message.UpdateUserMessage;
import aprivate.mo.tide.ui.personalcenter.profile.modify.ModifyPersonalProfileFragment;
import aprivate.mo.tide.utils.TideMessage;
import aprivate.mo.tide.widget.TideTitleBar;
import privat.mo.tidelib.base.BaseFragment;
import privat.mo.tidelib.listener.OnItemClickListener;

/**
 * Created by Mo on 2020/6/4
 */

public class PersonalProfileFragment extends BaseFragment<IPersonalProfileFragmentView, PersonalProfileFragmentPresenter>
        implements IPersonalProfileFragmentView {

    private TideTitleBar tittleBar;
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
        tittleBar = (TideTitleBar) view.findViewById(R.id.ttb_personal_profile);
        tittleBar.setTitle("个人资料");
        tittleBar.setBackClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
        rvProfile = (RecyclerView) view.findViewById(R.id.rv_personal_profile);
    }



    @Subscribe(sticky = true)
    public void onCheckPersonalProfile(TideUser user) {
        getPresenter().getPersonalProfileList(user);
    }

    @Subscribe
    public void onUpdatePersonalProfile(UpdateUserMessage fakeUser) {
        getPresenter().updatePersonalProfileList(fakeUser.getObjID());
    }

    /**
     * 初始化用户个人资料列表
     *
     * @param profileItems
     */
    @Override
    public void initPersonalProfileList(List<ProfileItem> profileItems, String objID) {
        mProfileAdpter = new PersonalProfileAdapter(profileItems);
        mProfileAdpter.setOnPersonalProfileItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder viewHolder) {
                if (profileItems.get(position).isModify()) {
                    start(ModifyPersonalProfileFragment.newInstance(profileItems.get(position), objID));
                } else {
                    TideMessage.showMessage("该项信息不可修改");
                }

            }

            @Override
            public void onItemLongClickListener(int position, View view, RecyclerView.ViewHolder viewHolder) {

            }
        });
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
