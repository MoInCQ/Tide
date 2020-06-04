package aprivate.mo.tide.ui.home;

import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.entity.City;
import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.entity.Store;
import aprivate.mo.tide.utils.TideMessage;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/1/27
 */

public class HomeFragmentPresenter extends BasePresenter<IHomeFragmentView> {

    private City mCitySelected;

    private List<Event> homeRecommends = new ArrayList<>();

    private List<Store> homeSelectedStores = new ArrayList<>();

    private List<Event> homeCityMaps = new ArrayList<>();


    /**
     * 获取选中城市
     */
    public void getHomeCitySelected() {
        if (mCitySelected == null) {
            return;
        }
        getView().initHomeCitySelected(mCitySelected);
    }


    /**
     * 获取首页 "推荐" 相关列表
     */
    public void getHomeRecommendList() {

        Event event = new Event();
        homeRecommends.add(event);

        Event event1 = new Event();
        homeRecommends.add(event1);

        Event event2 = new Event();
        homeRecommends.add(event2);

        Event event3 = new Event();
        homeRecommends.add(event3);

        Event event4 = new Event();
        homeRecommends.add(event4);

        getView().initHomeRecommendInfo(homeRecommends);
    }

    /**
     * 获取首页 "精选店铺" 相关列表
     */
    public void getHomeSelectedStoreList() {

        Store store = new Store();
        homeSelectedStores.add(store);

        Store store1 = new Store();
        homeSelectedStores.add(store1);

        Store store2 = new Store();
        homeSelectedStores.add(store2);

        Store store3 = new Store();
        homeSelectedStores.add(store3);

        Store store4 = new Store();
        homeSelectedStores.add(store4);

        getView().initHomeSelectedStoreInfo(homeSelectedStores);
    }

    /**
     * 获取首页 "城市地图" 相关列表
     */
    public void getHomeCityMapList() {

        Event event = new Event();
        homeCityMaps.add(event);

        Event event1 = new Event();
        homeCityMaps.add(event1);

        Event event2 = new Event();
        homeCityMaps.add(event2);

        Event event3 = new Event();
        homeCityMaps.add(event3);

        Event event4 = new Event();
        homeCityMaps.add(event4);

        getView().initHomeCityMapInfo(homeCityMaps);
    }
}
