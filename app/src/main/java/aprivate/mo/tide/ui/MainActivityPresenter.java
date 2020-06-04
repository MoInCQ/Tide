package aprivate.mo.tide.ui;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.entity.City;
import aprivate.mo.tide.utils.TideMessage;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/1/13
 */

public class MainActivityPresenter extends BasePresenter<IMainActivityView> {

    private List<City> cities = new ArrayList<>();

    /**
     * 获取城市列表
     */
    public void getCitySelectedList() {

        City city = new City();
        city.setName("上海");
        city.setEnglishName("Shanghai");
        cities.add(city);

        City city1 = new City();
        city1.setName("北京");
        city1.setEnglishName("Beijing");
        cities.add(city1);

        City city2 = new City();
        city2.setName("深圳");
        city2.setEnglishName("Shenzhen");
        cities.add(city2);

        City city3 = new City();
        city3.setName("广州");
        city3.setEnglishName("Guangzhou");
        cities.add(city3);

        City city4 = new City();
        city4.setName("南京");
        city4.setEnglishName("Nanjing");
        cities.add(city4);

        City city5 = new City();
        city5.setName("苏州");
        city5.setEnglishName("Suzhou");
        cities.add(city5);

        City city6 = new City();
        city6.setName("杭州");
        city6.setEnglishName("Hangzhou");
        cities.add(city6);

        getView().initCitySelectInfo(cities);
    }


    /**
     * 更换城市
     *
     * @param citySelectedsIndex
     */
    public void updateCitySelected(int citySelectedsIndex) {
        // TODO: 2020/6/2 完成更换城市-->更换内容逻辑
        City citySelected = cities.get(citySelectedsIndex);
        EventBus.getDefault().postSticky(citySelected);
        getView().updateCitySelected(citySelected);
    }

    /**
     * 获取选中城市信息
     */
    public void getCitySelected() {
        // TODO: 2020/6/2 接入数据库，与homeFragment统一
        City citySelected = cities.get(4);
        EventBus.getDefault().postSticky(citySelected);
        getView().initCitySelected(citySelected);
    }



}
