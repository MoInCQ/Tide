package aprivate.mo.tide.ui.home.store;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.entity.Event;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/6/6
 */

public class StoreFragmentPresenter extends BasePresenter<IStoreFragmentView> {

    private List<Event> eventList = new ArrayList<>();

    /**
     * 获取店铺相关活动列表
     */
    public void getStoreEventList() {
        Event event = new Event();
        eventList.add(event);

        Event event1 = new Event();
        eventList.add(event1);

        Event event2 = new Event();
        eventList.add(event2);

        Event event3 = new Event();
        eventList.add(event3);

        Event event4 = new Event();
        eventList.add(event4);

        getView().initStoreEventList(eventList);
    }
}
