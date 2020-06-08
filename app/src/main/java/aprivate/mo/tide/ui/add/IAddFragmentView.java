package aprivate.mo.tide.ui.add;

import privat.mo.tidelib.mvp.BaseView;

/**
 * Created by Mo on 2020/1/27
 */

public interface IAddFragmentView extends BaseView {

    void submitEventSuccess();

    void submitEventFail();

    void submitEventLimitAuthority();

}
