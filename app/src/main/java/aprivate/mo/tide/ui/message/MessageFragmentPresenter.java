package aprivate.mo.tide.ui.message;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Event;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/1/27
 */

public class MessageFragmentPresenter extends BasePresenter<IMessageFragmentView> {

    private List<Event> eventList = new ArrayList<>();

    private static final String INTRO = "    “大地上的异乡者”是南京先锋书店的标识，取自奥地利诗人特拉克尔的诗句。寓意人的精神永远在寻觅一个无所在的故乡，好的书店应该是读书人的精神家园。在读者心中，先锋就是这样一所精神家园。\n" +
            "    徜徉于书店，一股浓烈的文化气息扑面而来。百米艺术画廊上，世界名人画像无声地诠释着历史；天花板上，梵高、毕加索等大师的画像直触心灵；柱子上波德莱尔、马拉美等诗人的经典名句犹在耳畔……伴随着舒缓的音乐，这里的一切，有着洗涤心灵的力量。\n" +
            "    钱晓华是个爱书之人，书是他全部的信仰。先锋的每一本书，都由他亲自挑选，讲究思想深度和文化品位。为给读者营造出自由舒适的阅读氛围，先锋设有读者免费阅读休闲区，可以容纳几百人在此阅读。\n" +
            "    “找一个角落，在文脉书香中度过浮生半日，实在是一种享受。”南京师范大学学生苏羽常来这里，一待就是一天。\n" +
            "    专程从广州赶来的刘惠燕女士买了一推车的书，她笑着说：“先锋已成了一种文化符号。虽说网上买书价格优惠些，但我更享受这里购书过程中完美的文化体验。”\n" +
            "    有作家曾说：“好读书的人，都是些‘在路上’的人，他们的灵魂四处漂泊着。在漂泊的过程中，先锋书店为他们提供了一处暂时的、舒适的栖居地。”";


    public void getNotificationList() {



        Event event4 = new Event();
        event4.setTitle("总统府 x 民国书院");
        event4.setSubTitle("发现好去处");
        event4.setCover(R.drawable.img_city_living_room);
        event4.setAddress("江苏省南京市玄武区长江路292号总统府夕佳楼");
        event4.setTag("城市客厅");
        event4.setIntro(INTRO);
        event4.setDate("2020.02.02 晚");
        event4.setTime("7：00 - 9：00");
        event4.setSupposedPopulation(30);
        event4.setRegisterPopulation(21);
        event4.setFares(50);
        event4.setSponsor("南京总统府民国书院");
        eventList.add(event4);


        Event event = new Event();
        event.setTitle("先锋书店 x 南京大学");
        event.setSubTitle("发现好去处");
        event.setCover(R.drawable.img_recommend);
        event.setAddress("江苏省南京市鼓楼区汉口路22号");
        event.setTag("走进高校");
        event.setIntro(INTRO);
        event.setDate("2020.02.02 晚");
        event.setTime("7：00 - 9：00");
        event.setSupposedPopulation(30);
        event.setRegisterPopulation(21);
        event.setFares(50);
        event.setSponsor("南京先锋书店");
        eventList.add(event);

        Event event1 = new Event();
        event1.setTitle("1912 x Future CLUB");
        event1.setSubTitle("玩乐南京");
        event1.setCover(R.drawable.img_stage);
        event1.setAddress("江苏省南京市五台山体育中心5号门");
        event1.setTag("LiveHouse");
        event1.setIntro("    为什么这么多年轻人都喜欢逛夜店？也许只有在这里，你才能暂时忘记工作的压力，暂时忘记房贷、车贷，还有该如何去赚孩子的下一桶奶粉钱。\n" +
                "    在夜店，你可以喝最烈的酒，摇最猛的头，跳最销魂的舞，见最好看的妹子，熬最狠的夜，蹦最野的迪。\n" +
                "    遇到不如意的事，不妨去夜店开一瓶酒，几口下去，跟着音乐晃就完事了。\n" +
                "    在南京，走在1912或是其他繁华路段，随便一找便是几家夜店。如果你是南京人，或是因为某个原因来到南京，强烈推荐你去南京的夜店逛一逛。\n" +
                "    有酒乐逍遥，无酒我亦癫。跟随音乐晃，凡人也成仙。");
        event1.setDate("2020.12.25 晚");
        event1.setTime("7：00 - 9：00");
        event1.setSupposedPopulation(200);
        event1.setRegisterPopulation(20);
        event1.setFares(40);
        event1.setSponsor("南京 Future CLUB");
        eventList.add(event1);

        Event event2 = new Event();
        event2.setTitle("老门东 x 骏惠书屋");
        event2.setSubTitle("发现好去处");
        event2.setCover(R.drawable.img_read);
        event2.setAddress("江苏省南京市秦淮区中华门以东");
        event2.setTag("一本好书");
        event2.setIntro(INTRO);
        event2.setDate("2020.02.02 晚");
        event2.setTime("7：00 - 9：00");
        event2.setSupposedPopulation(30);
        event2.setRegisterPopulation(21);
        event2.setFares(50);
        event2.setSponsor("南京骏惠书屋");
        eventList.add(event2);

        Event event3 = new Event();
        event3.setTitle("《霍乱时期的爱情》");
        event3.setSubTitle("读书分享");
        event3.setCover(R.drawable.img_study);
        event3.setAddress("江苏省南京市鼓楼区江苏路39号");
        event3.setTag("一本好书");
        event3.setIntro(INTRO);
        event3.setDate("2020.02.02 晚");
        event3.setTime("7：00 - 9：00");
        event3.setSupposedPopulation(30);
        event3.setRegisterPopulation(21);
        event3.setFares(50);
        event3.setSponsor("南京颐和书馆");
        eventList.add(event3);


        getView().initNotificationList(eventList);
    }
}
