package aprivate.mo.tide.ui.personalcenter.profile;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.entity.ProfileItem;
import aprivate.mo.tide.entity.TideUser;
import aprivate.mo.tide.utils.TideMessage;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/6/4
 */

public class PersonalProfileFragmentPresenter extends BasePresenter<IPersonalProfileFragmentView> {

    private List<ProfileItem> profileItems = new ArrayList<>();
    private static final String DEFAULT_HINT = "待填写";

    /**
     * 获取个人信息列表
     * @param user
     */
    public void getPersonalProfileList(TideUser user) {
        queryPersonalProfile(user.getObjectId());


    }

    /**
     * 查询个人信息并初始化数据源
     * @param objID
     */
    private void queryPersonalProfile(String objID) {
        BmobQuery<TideUser> bmobQuery = new BmobQuery<TideUser>();
        bmobQuery.getObject(objID, new QueryListener<TideUser>() {
            @Override
            public void done(TideUser user, BmobException e) {
                if (e == null) {
                    profileItems.add(new ProfileItem("账号", user.getAccount(), false));
                    profileItems.add(new ProfileItem("用户名", user.getUserName(), true));
                    profileItems.add(new ProfileItem("手机号", TextUtils.isEmpty(user.getTel())
                            ? DEFAULT_HINT : user.getTel(), true));
                    profileItems.add(new ProfileItem("邮箱", TextUtils.isEmpty(user.getMail())
                            ? DEFAULT_HINT : user.getMail(), true));
                    getView().initPersonalProfileList(profileItems, user.getObjectId());
                } else {
                    TideMessage.showMessage("查询失败");
                }
            }
        });
    }

    public void updatePersonalProfileList(String tideUserObjID) {
        profileItems.clear();
        queryPersonalProfile(tideUserObjID);
    }

}
