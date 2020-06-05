package aprivate.mo.tide.ui.home;

import java.util.List;

import aprivate.mo.tide.entity.City;
import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.entity.Store;
import privat.mo.tidelib.mvp.BaseView;

/**
 * Created by Mo on 2020/1/27
 */

public interface IHomeFragmentView extends BaseView {


    void initHomeRecommendInfo(List<Event> homeRecommendList);

    void initHomeSelectedStoreInfo(List<Store> homeSelectedStoreList);

    void initHomeCityMapInfo(List<Event> homeCityMapList);
}
