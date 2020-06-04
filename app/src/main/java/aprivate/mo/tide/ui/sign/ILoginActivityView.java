package aprivate.mo.tide.ui.sign;

import aprivate.mo.tide.entity.TideUser;
import privat.mo.tidelib.mvp.BaseView;

/**
 * Created by Mo on 2020/3/17
 */

public interface ILoginActivityView extends BaseView {
    void loginSuccess(TideUser user);
    void loginFail();

}
