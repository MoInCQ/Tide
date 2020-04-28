package aprivate.mo.tide.ui.message;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.entity.Event;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/1/27
 */

public class MessageFragmentPresenter extends BasePresenter<IMessageFragmentView> {

    private List<Event> eventList = new ArrayList<>();

    public void getNotificationList() {

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

        Event event7 = new Event();
        eventList.add(event7);

        Event event8 = new Event();
        eventList.add(event8);

        Event event9 = new Event();
        eventList.add(event9);

        getView().initNotificationList(eventList);
    }
}
