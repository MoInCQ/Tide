package aprivate.mo.tide.ui.personalcenter.profile.modify;

import org.greenrobot.eventbus.EventBus;

import aprivate.mo.tide.entity.TideUser;
import aprivate.mo.tide.Message.UpdateUserMessage;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/6/6
 */

public class ModifyPersonalProfileFragmentPresenter
        extends BasePresenter<IModifyPersonalProfileFragmentView> {

    /**
     * 保存修改
     * @param key
     * @param value
     */
    public void saveModify(String objID, String key, String value) {
        TideUser user = new TideUser();
        switch (key) {
            case "用户名":
                user.setUserName(value);
                break;
            case "手机号":
                user.setTel(value);
                break;
            case "邮箱":
                user.setMail(value);
                break;
                default:
        }
        user.update(objID, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    EventBus.getDefault().post(new UpdateUserMessage(objID));
                    getView().saveModifySuccess();
                } else {
                    getView().saveModifyFail(e.getMessage());
                }
            }
        });
    }
}
