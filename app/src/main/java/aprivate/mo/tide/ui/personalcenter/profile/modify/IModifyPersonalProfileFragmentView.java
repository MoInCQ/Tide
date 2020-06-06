package aprivate.mo.tide.ui.personalcenter.profile.modify;

import privat.mo.tidelib.mvp.BaseView;

/**
 * Created by Mo on 2020/6/6
 */

public interface IModifyPersonalProfileFragmentView extends BaseView {

    void saveModifySuccess();

    void saveModifyFail(String errorMessage);
}
