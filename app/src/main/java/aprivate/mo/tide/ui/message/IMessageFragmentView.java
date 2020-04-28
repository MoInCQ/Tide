package aprivate.mo.tide.ui.message;

import java.util.List;

import aprivate.mo.tide.entity.Event;
import privat.mo.tidelib.mvp.BaseView;

/**
 * Created by Mo on 2020/1/27
 */

public interface IMessageFragmentView extends BaseView {

    void initNotificationList(List<Event> events);
}
