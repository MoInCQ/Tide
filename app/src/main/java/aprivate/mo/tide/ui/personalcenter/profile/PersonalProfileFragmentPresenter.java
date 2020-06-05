package aprivate.mo.tide.ui.personalcenter.profile;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.entity.ProfileItem;
import aprivate.mo.tide.entity.TideUser;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/6/4
 */

public class PersonalProfileFragmentPresenter extends BasePresenter<IPersonalProfileFragmentView> {

    private List<ProfileItem> profileItems = new ArrayList<>();
    private static final String DEFAULT_HINT = "待填写";

    public void getPersonalProfileList(TideUser user) {
        profileItems.add(new ProfileItem("账号", user.getAccount(), false));
        profileItems.add(new ProfileItem("用户名", user.getUserName(), false));
        profileItems.add(new ProfileItem("手机号", TextUtils.isEmpty(user.getTel())
                ? DEFAULT_HINT : user.getTel(), true));
        profileItems.add(new ProfileItem("邮箱", TextUtils.isEmpty(user.getMail())
                ? DEFAULT_HINT : user.getMail(), true));
        getView().initPersonalProfileList(profileItems);
    }
}
