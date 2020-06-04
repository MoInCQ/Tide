package aprivate.mo.tide.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Mo on 2020/3/10
 *
 * 事件实体(作为所有事件的父类 eg：推荐活动、文章、店铺)
 */

public class Event extends BmobObject {

    private String title;
    private String tag;
    private String subTitle;
    private String coverImgUrl;
    private String intro;

    private String address;
    private String date;
    private String time;
    private String sponsor;

    private int fares;
    private int supposedPopulation;
    private int registerdPopulation;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public int getFares() {
        return fares;
    }

    public void setFares(int fares) {
        this.fares = fares;
    }

    public int getSupposedPopulation() {
        return supposedPopulation;
    }

    public void setSupposedPopulation(int supposedPopulation) {
        this.supposedPopulation = supposedPopulation;
    }

    public int getRegisterdPopulation() {
        return registerdPopulation;
    }

    public void setRegisterdPopulation(int registerdPopulation) {
        this.registerdPopulation = registerdPopulation;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }
}
