package aprivate.mo.tide.ui.sign;

import android.text.TextUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.entity.TideUser;
import aprivate.mo.tide.utils.TideMessage;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/3/17
 */

public class LoginActivityPresenter extends BasePresenter<ILoginActivityView> {

    /**
     * 登陆
     * @param account
     * @param password
     */
    public void login(String account, String password) {

        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            TideMessage.showMessage("所有待填项不能为空！");
            return;
        }

        // 组合查询条件(账号+密码)
        List<BmobQuery<TideUser>> andQuerys = new ArrayList<BmobQuery<TideUser>>();
        BmobQuery<TideUser> accountQuery = new BmobQuery<>();
        accountQuery.addWhereEqualTo("account", account);
        BmobQuery<TideUser> passwordQuery = new BmobQuery<>();
        passwordQuery.addWhereEqualTo("password", password);
        andQuerys.add(accountQuery);
        andQuerys.add(passwordQuery);

        BmobQuery<TideUser> query = new BmobQuery<TideUser>();
        query.and(andQuerys);
        query.findObjects(new FindListener<TideUser>() {
            @Override
            public void done(List<TideUser> list, BmobException e) {
                if (list == null || list.isEmpty() || e != null) {
                    getView().loginFail(e);
                } else {
                    TideUser user = list.get(0);
                    // 验证登陆成功后将TideUser实体发布到事件总线上
                    EventBus.getDefault().postSticky(user);
                    getView().loginSuccess(user);
                }
            }
        });
    }

    /**
     * 注册
     * @param account
     * @param password
     * @param userName
     */
    public void register(String account, String password, String userName) {
        if (TextUtils.isEmpty(account)
                || TextUtils.isEmpty(password)
                || TextUtils.isEmpty(userName)) {
            TideMessage.showMessage("所有待填项不能为空！");
            return;
        }
        TideUser user = new TideUser();
        user.setAccount(account);
        user.setPassword(password);
        user.setUserName(userName);
        user.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if(e == null){
                    user.setObjectId(objectId);
                    getView().registerSuccess(user);
                }else{
                    getView().loginFail(e);
                }
            }
        });
    }
}
