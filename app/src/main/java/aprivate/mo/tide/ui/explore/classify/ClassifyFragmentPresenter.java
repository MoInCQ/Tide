package aprivate.mo.tide.ui.explore.classify;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.entity.Store;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/3/17
 */

public class ClassifyFragmentPresenter extends BasePresenter<IClassifyFragmentView> {

    private List<Store> storeList = new ArrayList<>();

    private List<Event> eventList = new ArrayList<>();

    public void getStoreList() {

        Store store = new Store();
        storeList.add(store);

        Store store1 = new Store();
        storeList.add(store1);

        Store store2 = new Store();
        storeList.add(store2);

        Store store3 = new Store();
        storeList.add(store3);

        Store store4 = new Store();
        storeList.add(store4);

        getView().initStoreList(storeList);
    }

    public void getEventList() {

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

        Event event5 = new Event();
        eventList.add(event5);

        Event event6 = new Event();
        eventList.add(event6);

        getView().initEventList(eventList);
    }
}
