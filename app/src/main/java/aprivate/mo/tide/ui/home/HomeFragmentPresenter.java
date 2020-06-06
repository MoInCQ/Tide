package aprivate.mo.tide.ui.home;

import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.R;
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
    public void initHomeCitySelected(City city) {
        mCitySelected = city;
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
        store.setCover(R.drawable.img_selected_store);
        store.setName("先锋书店");
        store.setCity("南京");
        store.setAddress("南京市鼓楼区广州路173号");
        store.setIntro("南京先锋书店于1996年在南京创立，是国内知名的民营学术书店，自创立以来探索出一条以“学术、文化沙龙、咖啡、艺术画廊、电影、音乐、创意、生活、时尚”为主题的文化创意品牌书店经营模式，搭建一座可供开放、探讨、分享的公共性平台。");
        homeSelectedStores.add(store);

        Store store1 = new Store();
        store1.setCover(R.drawable.img_selected_store);
        store1.setName("南书房");
        store1.setCity("南京");
        store1.setAddress("南京市鼓楼区广州路173号");
        store1.setIntro("南京先锋书店于1996年在南京创立，是国内知名的民营学术书店，自创立以来探索出一条以“学术、文化沙龙、咖啡、艺术画廊、电影、音乐、创意、生活、时尚”为主题的文化创意品牌书店经营模式，搭建一座可供开放、探讨、分享的公共性平台。");
        homeSelectedStores.add(store1);

        Store store2 = new Store();
        store2.setCover(R.drawable.img_selected_store);
        store2.setName("博雅书屋");
        store2.setCity("南京");
        store2.setAddress("南京市鼓楼区广州路173号");
        store2.setIntro("南京先锋书店于1996年在南京创立，是国内知名的民营学术书店，自创立以来探索出一条以“学术、文化沙龙、咖啡、艺术画廊、电影、音乐、创意、生活、时尚”为主题的文化创意品牌书店经营模式，搭建一座可供开放、探讨、分享的公共性平台。");
        homeSelectedStores.add(store2);

        Store store3 = new Store();
        store3.setCover(R.drawable.img_selected_store);
        store3.setName("永丰诗社");
        store3.setCity("南京");
        store3.setAddress("南京市鼓楼区广州路173号");
        store3.setIntro("南京先锋书店于1996年在南京创立，是国内知名的民营学术书店，自创立以来探索出一条以“学术、文化沙龙、咖啡、艺术画廊、电影、音乐、创意、生活、时尚”为主题的文化创意品牌书店经营模式，搭建一座可供开放、探讨、分享的公共性平台。");
        homeSelectedStores.add(store3);

        Store store4 = new Store();
        store4.setCover(R.drawable.img_selected_store);
        store4.setName("西冷印社");
        store4.setCity("南京");
        store4.setAddress("南京市鼓楼区广州路173号");
        store4.setIntro("南京先锋书店于1996年在南京创立，是国内知名的民营学术书店，自创立以来探索出一条以“学术、文化沙龙、咖啡、艺术画廊、电影、音乐、创意、生活、时尚”为主题的文化创意品牌书店经营模式，搭建一座可供开放、探讨、分享的公共性平台。");
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
