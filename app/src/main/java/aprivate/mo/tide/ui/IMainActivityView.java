package aprivate.mo.tide.ui;

import java.util.List;

import aprivate.mo.tide.entity.City;
import privat.mo.tidelib.mvp.BaseView;

/**
 * Created by Mo on 2020/1/13
 */

public interface IMainActivityView extends BaseView {

    void initCitySelectInfo(List<City> cityList);

    void updateCitySelected(City city);

    void initCitySelected(City city);
}
