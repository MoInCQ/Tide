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
        store1.setCover(R.drawable.img_city_living_room);
        store1.setName("二楼南书房");
        store1.setCity("南京");
        store1.setAddress("南京市秦淮区秣陵路21号民国建筑4号楼2楼");
        store1.setIntro("时代似乎并没有给予纸质深度阅读多少关注。物质主义的盛行和互联网的繁荣，将我们的阅读空间压缩得越来越小，而“二楼南书房”似乎是在温柔地敲打着这个粗砺的世界。“不灭的理想，不关灯的书房”，这座隐于闹市24小时开放的书房，如同城市黑夜里的一盏温暖明灯，静悄悄地目送着你离去，也静悄悄地欢迎着你到来。");
        homeSelectedStores.add(store1);

        Store store2 = new Store();
        store2.setCover(R.drawable.img_write);
        store2.setName("万象书坊");
        store2.setCity("南京");
        store2.setAddress("鼓楼区青岛路33号（近南京大学南门）");
        store2.setIntro("万象书坊将积极发挥人文书店对大众阅读的引导作用，丰富线下阅读体验，通过实体书店开展各种线下的活动，其中既有精英学者的学术分享，也有普通文青的阅读互动参与，与时俱进地展现南京这座城市对阅读文化的谋求，促成万象成为南京一个新的地标性的人文空间。");
        homeSelectedStores.add(store2);

        Store store3 = new Store();
        store3.setCover(R.drawable.img_tea);
        store3.setName("永丰诗社");
        store3.setCity("南京");
        store3.setAddress("南京市玄武区钟山风景名胜区内");
        store3.setIntro("神秘的黄昏，彩虹似女人的黛眉，树上的小鸟，音乐喷泉...这里简直是诗的绿洲，永无落日的诗光；茨维塔耶娃斑驳的钢琴，普希金的打字机，聂鲁达的地球仪，博尔赫斯的留声机，这里的每一件都充实人心灵的灿烂，让你度过内心静默的一天。");
        homeSelectedStores.add(store3);

        Store store4 = new Store();
        store4.setCover(R.drawable.img_exhibition);
        store4.setName("金陵书苑");
        store4.setCity("南京");
        store4.setAddress("南京市鼓楼区广州路173号");
        store4.setIntro("在古代，城墙里面就是家；有人说，有书的地方就是家。身处这个电子阅读的时代，当书店遇到城墙，历史文化的气息便扑面而来。躲在南京老城墙里的一家免费读书的空间，地道的民国风格，每个桌子上都有一个小盆栽，灯光不是很强烈，很适合阅读。安静的空气，历史的气息，不知不觉一个躁动的下午就被这样被抚平了。更难得的是，在这里，真读书的人多过附庸风雅的人。奶茶，蛋糕和小食均划算，好像这家书苑的出现，就是为了让人们感动于书香。");
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
