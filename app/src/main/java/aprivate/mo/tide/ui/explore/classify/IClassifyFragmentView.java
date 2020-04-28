package aprivate.mo.tide.ui.explore.classify;

import java.util.List;

import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.entity.Store;
import privat.mo.tidelib.mvp.BaseView;

/**
 * Created by Mo on 2020/3/17
 */

public interface IClassifyFragmentView extends BaseView {

    void initStoreList(List<Store> storeList);

    void initEventList(List<Event> eventList);
}
