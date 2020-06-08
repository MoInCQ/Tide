package aprivate.mo.tide.ui.explore.classify;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.entity.Store;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/3/17
 */

public class ClassifyFragmentPresenter extends BasePresenter<IClassifyFragmentView> {

    private List<Store> storeList = new ArrayList<>();

    private List<Event> eventList = new ArrayList<>();

    private static final String INTRO = "    “大地上的异乡者”是南京先锋书店的标识，取自奥地利诗人特拉克尔的诗句。寓意人的精神永远在寻觅一个无所在的故乡，好的书店应该是读书人的精神家园。在读者心中，先锋就是这样一所精神家园。\n" +
            "    徜徉于书店，一股浓烈的文化气息扑面而来。百米艺术画廊上，世界名人画像无声地诠释着历史；天花板上，梵高、毕加索等大师的画像直触心灵；柱子上波德莱尔、马拉美等诗人的经典名句犹在耳畔……伴随着舒缓的音乐，这里的一切，有着洗涤心灵的力量。\n" +
            "    钱晓华是个爱书之人，书是他全部的信仰。先锋的每一本书，都由他亲自挑选，讲究思想深度和文化品位。为给读者营造出自由舒适的阅读氛围，先锋设有读者免费阅读休闲区，可以容纳几百人在此阅读。\n" +
            "    “找一个角落，在文脉书香中度过浮生半日，实在是一种享受。”南京师范大学学生苏羽常来这里，一待就是一天。\n" +
            "    专程从广州赶来的刘惠燕女士买了一推车的书，她笑着说：“先锋已成了一种文化符号。虽说网上买书价格优惠些，但我更享受这里购书过程中完美的文化体验。”\n" +
            "    有作家曾说：“好读书的人，都是些‘在路上’的人，他们的灵魂四处漂泊着。在漂泊的过程中，先锋书店为他们提供了一处暂时的、舒适的栖居地。”";


    public void getStoreList() {

        Store store = new Store();
        store.setCover(R.drawable.img_selected_store);
        store.setName("先锋书店");
        store.setCity("南京");
        store.setAddress("南京市鼓楼区广州路173号");
        store.setIntro("南京先锋书店于1996年在南京创立，是国内知名的民营学术书店，自创立以来探索出一条以“学术、文化沙龙、咖啡、艺术画廊、电影、音乐、创意、生活、时尚”为主题的文化创意品牌书店经营模式，搭建一座可供开放、探讨、分享的公共性平台。");
        storeList.add(store);

        Store store1 = new Store();
        store1.setCover(R.drawable.img_city_living_room);
        store1.setName("二楼南书房");
        store1.setCity("南京");
        store1.setAddress("南京市秦淮区秣陵路21号民国建筑4号楼2楼");
        store1.setIntro("时代似乎并没有给予纸质深度阅读多少关注。物质主义的盛行和互联网的繁荣，将我们的阅读空间压缩得越来越小，而“二楼南书房”似乎是在温柔地敲打着这个粗砺的世界。“不灭的理想，不关灯的书房”，这座隐于闹市24小时开放的书房，如同城市黑夜里的一盏温暖明灯，静悄悄地目送着你离去，也静悄悄地欢迎着你到来。");
        storeList.add(store1);

        Store store2 = new Store();
        store2.setCover(R.drawable.img_write);
        store2.setName("万象书坊");
        store2.setCity("南京");
        store2.setAddress("鼓楼区青岛路33号（近南京大学南门）");
        store2.setIntro("万象书坊将积极发挥人文书店对大众阅读的引导作用，丰富线下阅读体验，通过实体书店开展各种线下的活动，其中既有精英学者的学术分享，也有普通文青的阅读互动参与，与时俱进地展现南京这座城市对阅读文化的谋求，促成万象成为南京一个新的地标性的人文空间。");
        storeList.add(store2);

        Store store3 = new Store();
        store3.setCover(R.drawable.img_tea);
        store3.setName("永丰诗社");
        store3.setCity("南京");
        store3.setAddress("南京市玄武区钟山风景名胜区内");
        store3.setIntro("神秘的黄昏，彩虹似女人的黛眉，树上的小鸟，音乐喷泉...这里简直是诗的绿洲，永无落日的诗光；茨维塔耶娃斑驳的钢琴，普希金的打字机，聂鲁达的地球仪，博尔赫斯的留声机，这里的每一件都充实人心灵的灿烂，让你度过内心静默的一天。");
        storeList.add(store3);

        Store store4 = new Store();
        store4.setCover(R.drawable.img_exhibition);
        store4.setName("金陵书苑");
        store4.setCity("南京");
        store4.setAddress("南京市鼓楼区广州路173号");
        store4.setIntro("在古代，城墙里面就是家；有人说，有书的地方就是家。身处这个电子阅读的时代，当书店遇到城墙，历史文化的气息便扑面而来。躲在南京老城墙里的一家免费读书的空间，地道的民国风格，每个桌子上都有一个小盆栽，灯光不是很强烈，很适合阅读。安静的空气，历史的气息，不知不觉一个躁动的下午就被这样被抚平了。更难得的是，在这里，真读书的人多过附庸风雅的人。奶茶，蛋糕和小食均划算，好像这家书苑的出现，就是为了让人们感动于书香。");
        storeList.add(store4);


        getView().initStoreList(storeList);
    }

    public void getEventList() {



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

        getView().initEventList(eventList);
    }
}
