package aprivate.mo.tide.ui.sign;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.bean.TideUser;
import aprivate.mo.tide.utils.TideMessage;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import privat.mo.tidelib.mvp.BasePresenter;

/**
 * Created by Mo on 2020/3/17
 */

public class LoginActivityPresenter extends BasePresenter<ILoginActivityView> {

    public void login(String account, String password) {

        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            TideMessage.showMessage("所有待填项不能为空！");
            return;
        }

        // 组合查询条件
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
                    getView().loginFail();
                } else {
                    getView().loginSuccess(list.get(0));
                }
            }
        });
    }
}
