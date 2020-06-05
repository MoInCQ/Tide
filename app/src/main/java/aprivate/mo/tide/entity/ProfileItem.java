package aprivate.mo.tide.entity;

/**
 * Created by Mo on 2020/6/5
 */

public class ProfileItem {

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
}
