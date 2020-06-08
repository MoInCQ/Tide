package aprivate.mo.tide.ui.add;

import android.text.TextUtils;

import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.entity.TideUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/1/27
 */

public class AddFragmentPresenter extends BasePresenter<IAddFragmentView> {

    /**
     * 提交Event到后台
     *
     * @param event
     */
    public void submitEvent(TideUser user, Event event) {
        if (TextUtils.isEmpty(event.getTitle())
                || TextUtils.isEmpty(event.getTime())
                || TextUtils.isEmpty(event.getAddress())
                || event.getSupposedPopulation() == 0
                || TextUtils.isEmpty(event.getTag())
                || event.getFares() == 0
                || TextUtils.isEmpty(event.getIntro())) {
            getView().submitEventFail();
            return;
        }

        // TODO: 2020/6/8 演示填充逻辑
        if (!user.getAccount().equals("admin")) {
            getView().submitEventLimitAuthority();
            return;
        }

        event.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    getView().submitEventSuccess();
                } else {
                    getView().submitEventFail();
                }
            }
        });
    }
}
