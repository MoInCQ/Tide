package aprivate.mo.tide.ui.personalcenter.profile.modify;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.ProfileItem;
import aprivate.mo.tide.utils.TideMessage;
import aprivate.mo.tide.widget.TideTitleBar;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/6/6
 *
 * 修改个人信息
 */

public class ModifyPersonalProfileFragment
        extends BaseFragment<IModifyPersonalProfileFragmentView, ModifyPersonalProfileFragmentPresenter>
        implements IModifyPersonalProfileFragmentView {

    /**
     * 获取索引数据初始化
     */
    private static final String ARG_ITEM = "arg_item";
    private static final String ARG_OBG_ID = "arg_obj_id";
    private ProfileItem mProfileItem;
    private String mObjID;

    private TideTitleBar titleBar;
    private EditText etContent;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_modify_personal_profile;
    }

    @Override
    protected ModifyPersonalProfileFragmentPresenter createPresenter() {
        return new ModifyPersonalProfileFragmentPresenter();
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
        mProfileItem = getArguments().getParcelable(ARG_ITEM);
        mObjID = (String) getArguments().get(ARG_OBG_ID);

        etContent = (EditText) view.findViewById(R.id.et_modify_personal_profile);
        etContent.setText(mProfileItem.getContent());

        titleBar = (TideTitleBar) view.findViewById(R.id.ttb_modify_personal_profile);
        titleBar.setBackClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
        titleBar.setTitle("修改" + mProfileItem.getTitle());
        titleBar.setSubTitleVisible(true);
        titleBar.setSubTitle("保存修改");
        titleBar.setSubTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().saveModify(mObjID, mProfileItem.getTitle(), etContent.getText().toString());
            }
        });

    }

    /**
     * 保存修改成功
     */
    @Override
    public void saveModifySuccess() {
        TideMessage.showMessage("保存成功！");
        pop();
    }

    /**
     * 保存修改失败
     */
    @Override
    public void saveModifyFail(String errorMessage) {
        TideMessage.showMessage("保存失败！" + errorMessage);
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

    public static ModifyPersonalProfileFragment newInstance(ProfileItem profileItem, String objID) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_ITEM, profileItem);
        args.putString(ARG_OBG_ID, objID);
        ModifyPersonalProfileFragment modifyPersonalProfileFragment = new ModifyPersonalProfileFragment();
        modifyPersonalProfileFragment.setArguments(args);
        return modifyPersonalProfileFragment;
    }
}
