package aprivate.mo.tide.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Mo on 2020/5/22
 */

public class TideUser extends BmobObject {

    private String account;
    private String password;
    private String userName;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
