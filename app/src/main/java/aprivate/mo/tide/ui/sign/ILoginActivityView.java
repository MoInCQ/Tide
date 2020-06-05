package aprivate.mo.tide.ui.sign;

import aprivate.mo.tide.entity.TideUser;
import cn.bmob.v3.exception.BmobException;
import privat.mo.tidelib.mvp.BaseView;

/**
 * Created by Mo on 2020/3/17
 */

public interface ILoginActivityView extends BaseView {
    void loginSuccess(TideUser user);
    void loginFail(BmobException e);

    void registerSuccess(TideUser user);
    void registerFail(BmobException e);

}
