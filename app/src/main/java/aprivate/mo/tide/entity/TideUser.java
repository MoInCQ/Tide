package aprivate.mo.tide.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Mo on 2020/5/22
 */

public class TideUser extends BmobObject {

    private String account;
    private String password;
    private String userName;
    private int gender;
    private boolean isAuthority;
    private int age;
    private int selectCity;
    private String tel;
    private String mail;
    private String portraitUrl;

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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isAuthority() {
        return isAuthority;
    }

    public void setAuthority(boolean authority) {
        isAuthority = authority;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSelectCity() {
        return selectCity;
    }

    public void setSelectCity(int selectCity) {
        this.selectCity = selectCity;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }
}
