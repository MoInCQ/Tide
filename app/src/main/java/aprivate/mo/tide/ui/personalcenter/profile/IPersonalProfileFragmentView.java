package aprivate.mo.tide.ui.personalcenter.profile;

import java.util.List;

import aprivate.mo.tide.entity.ProfileItem;
import privat.mo.tidelib.mvp.BaseView;
import privat.mo.tidelib.mvp.IView;

/**
 * Created by Mo on 2020/6/4
 */

public interface IPersonalProfileFragmentView extends BaseView {

    void initPersonalProfileList(List<ProfileItem> profileItems, String objID);

}
