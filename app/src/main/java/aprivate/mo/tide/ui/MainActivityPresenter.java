package aprivate.mo.tide.ui;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.entity.CitySelected;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/1/13
 */

public class MainActivityPresenter extends BasePresenter<IMainActivityView> {

    private List<CitySelected> citySelecteds = new ArrayList<>();

    /**
     * 获取城市列表
     */
    public void getCitySelectedList() {

        CitySelected citySelected = new CitySelected();
        citySelected.setName("上海");
        citySelected.setEnglishName("Shanghai");
        citySelecteds.add(citySelected);

        CitySelected citySelected1 = new CitySelected();
        citySelected1.setName("北京");
        citySelected1.setEnglishName("Beijing");
        citySelecteds.add(citySelected1);

        CitySelected citySelected2 = new CitySelected();
        citySelected2.setName("深圳");
        citySelected2.setEnglishName("Shenzhen");
        citySelecteds.add(citySelected2);

        CitySelected citySelected3 = new CitySelected();
        citySelected3.setName("广州");
        citySelected3.setEnglishName("Guangzhou");
        citySelecteds.add(citySelected3);

        CitySelected citySelected4 = new CitySelected();
        citySelected4.setName("南京");
        citySelected4.setEnglishName("Nanjing");
        citySelecteds.add(citySelected4);

        CitySelected citySelected5 = new CitySelected();
        citySelected5.setName("苏州");
        citySelected5.setEnglishName("Suzhou");
        citySelecteds.add(citySelected5);

        CitySelected citySelected6 = new CitySelected();
        citySelected6.setName("杭州");
        citySelected6.setEnglishName("Hangzhou");
        citySelecteds.add(citySelected6);

        getView().initCitySelectInfo(citySelecteds);
    }


    /**
     * 更换城市
     *
     * @param citySelectedsIndex
     */
    public void updateCitySelected(int citySelectedsIndex) {
        getView().updateCitySelected(citySelecteds.get(citySelectedsIndex));
    }

}
