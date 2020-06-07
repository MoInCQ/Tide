package aprivate.mo.tide.ui.home.store;

import java.util.List;

import aprivate.mo.tide.entity.Event;
import privat.mo.tidelib.mvp.BaseView;

/**
 * Created by Mo on 2020/6/6
 */

public interface IStoreFragmentView extends BaseView {

    void initStoreEventList(List<Event> eventList);

}
