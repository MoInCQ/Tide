package aprivate.mo.tide.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mo on 2020/3/10
 *
 * "店铺" 实体
 */

public class Store implements Parcelable {

    private String name;
    private String address;
    private String type;
    private int typeIndex;
    private String city;
    private String owner;
    private String slogan;
    private String intro;
    private int cover;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(type);
        dest.writeInt(typeIndex);
        dest.writeString(city);
        dest.writeString(owner);
        dest.writeString(slogan);
        dest.writeString(intro);
        dest.writeInt(cover);
    }

    public Store() { }

    private Store(Parcel source) {
        this.name = source.readString();
        this.address = source.readString();
        this.type = source.readString();
        this.typeIndex = source.readInt();
        this.city = source.readString();
        this.owner = source.readString();
        this.slogan = source.readString();
        this.intro = source.readString();
        this.cover = source.readInt();
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel source) {
            Store store = new Store(source);
            return store;
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(int typeIndex) {
        this.typeIndex = typeIndex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }
}
