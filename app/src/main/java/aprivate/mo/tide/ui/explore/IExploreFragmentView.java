package aprivate.mo.tide.ui.explore;

import java.util.List;

import aprivate.mo.tide.entity.Classify;
import privat.mo.tidelib.mvp.BaseView;

/**
 * Created by Mo on 2020/1/27
 */

public interface IExploreFragmentView extends BaseView {

    void initClassifyList(List<Classify> classifies);

}
