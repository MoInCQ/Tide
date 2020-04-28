package aprivate.mo.tide.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mo on 2020/3/10
 */

public class Classify implements Parcelable {

    private String type;
    private int typeIndex;
    private int cover;

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

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeInt(typeIndex);
        dest.writeInt(cover);
    }

    public static final Creator<Classify> CREATOR = new Creator<Classify>() {
        @Override
        public Classify createFromParcel(Parcel source) {
            return new Classify();
        }

        @Override
        public Classify[] newArray(int size) {
            return new Classify[size];
        }
    };
}
