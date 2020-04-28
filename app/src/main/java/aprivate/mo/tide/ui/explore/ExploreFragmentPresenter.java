package aprivate.mo.tide.ui.explore;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Classify;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/1/27
 */

public class ExploreFragmentPresenter extends BasePresenter<IExploreFragmentView> {

    private List<Classify> classifyList = new ArrayList<>();

    public void getClassifyList() {

        Classify classify = new Classify();
        classify.setType("城市客厅");
        classify.setCover(R.drawable.img_city_living_room);
        classifyList.add(classify);

        Classify classify1 = new Classify();
        classify1.setType("流浪图书馆");
        classify1.setCover(R.drawable.img_recommend);
        classifyList.add(classify1);

        Classify classify2 = new Classify();
        classify2.setType("需要喝酒");
        classify2.setCover(R.drawable.img_bar);
        classifyList.add(classify2);

        Classify classify3 = new Classify();
        classify3.setType("好书分享");
        classify3.setCover(R.drawable.img_read);
        classifyList.add(classify3);

        Classify classify4 = new Classify();
        classify4.setType("自习室计划");
        classify4.setCover(R.drawable.img_study);
        classifyList.add(classify4);

        Classify classify5 = new Classify();
        classify5.setType("小众观影");
        classify5.setCover(R.drawable.img_movie);
        classifyList.add(classify5);

        Classify classify6 = new Classify();
        classify6.setType("LIVE HOUSE");
        classify6.setCover(R.drawable.img_stage);
        classifyList.add(classify6);

        Classify classify7 = new Classify();
        classify7.setType("传承手工艺");
        classify7.setCover(R.drawable.img_handicraft);
        classifyList.add(classify7);

        Classify classify8 = new Classify();
        classify8.setType("共享美味");
        classify8.setCover(R.drawable.img_share_food);
        classifyList.add(classify8);

        Classify classify9 = new Classify();
        classify9.setType("一张照片");
        classify9.setCover(R.drawable.img_camera);
        classifyList.add(classify9);

        Classify classify10 = new Classify();
        classify10.setType("一杯清茶");
        classify10.setCover(R.drawable.img_tea);
        classifyList.add(classify10);

        Classify classify11 = new Classify();
        classify11.setType("一手好字");
        classify11.setCover(R.drawable.img_write);
        classifyList.add(classify11);

        Classify classify12 = new Classify();
        classify12.setType("一出好戏");
        classify12.setCover(R.drawable.img_drama);
        classifyList.add(classify12);

        Classify classify13 = new Classify();
        classify13.setType("一场艺术展");
        classify13.setCover(R.drawable.img_exhibition);
        classifyList.add(classify13);




        getView().initClassifyList(classifyList);
    }
}
