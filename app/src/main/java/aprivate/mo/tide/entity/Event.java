package aprivate.mo.tide.entity;

import android.os.Parcel;
import android.os.Parcelable;

import cn.bmob.v3.BmobObject;

/**
 * Created by Mo on 2020/3/10
 *
 * 事件实体(作为所有事件的父类 eg：推荐活动、文章)
 */

public class Event extends BmobObject implements Parcelable {

    private String title;
    private String tag;
    private String subTitle;
    private int cover;
    private String intro;

    private String address;
    private String date;
    private String time;
    private String sponsor;

    private int fares;
    private int supposedPopulation;
    private int registerPopulation;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(tag);
        dest.writeString(subTitle);
        dest.writeInt(cover);
        dest.writeString(intro);

        dest.writeString(address);
        dest.writeString(date);
        dest.writeString(time);
        dest.writeString(sponsor);

        dest.writeInt(fares);
        dest.writeInt(supposedPopulation);
        dest.writeInt(registerPopulation);
    }

    public Event() { }

    private Event(Parcel source) {
        this.title = source.readString();
        this.tag = source.readString();
        this.subTitle = source.readString();
        this.cover = source.readInt();
        this.intro = source.readString();

        this.address = source.readString();
        this.date = source.readString();
        this.time = source.readString();
        this.sponsor = source.readString();

        this.fares = source.readInt();
        this.supposedPopulation = source.readInt();
        this.registerPopulation = source.readInt();

    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel source) {
            Event event = new Event(source);
            return event;
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

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

    public int getRegisterPopulation() {
        return registerPopulation;
    }

    public void setRegisterPopulation(int registerPopulation) {
        this.registerPopulation = registerPopulation;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }
}
