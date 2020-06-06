package aprivate.mo.tide.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mo on 2020/6/5
 */

public class ProfileItem implements Parcelable {

    private String title;
    private String content;
    private boolean modify;

    public ProfileItem(String title, String content, boolean modify) {
        this.title = title;
        this.content = content;
        this.modify = modify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isModify() {
        return modify;
    }

    public void setModify(boolean modify) {
        this.modify = modify;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeByte((byte) (modify ? 1 : 0));
    }

    public static final Creator<ProfileItem> CREATOR = new Creator<ProfileItem>() {
        @Override
        public ProfileItem createFromParcel(Parcel source) {
            ProfileItem profileItem = new ProfileItem(source.readString()
                    , source.readString(), source.readByte() != 0);
            return profileItem;
        }

        @Override
        public ProfileItem[] newArray(int size) {
            return new ProfileItem[size];
        }
    };
}
