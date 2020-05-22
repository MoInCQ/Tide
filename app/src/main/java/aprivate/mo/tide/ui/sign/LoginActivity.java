package aprivate.mo.tide.ui.sign;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import aprivate.mo.tide.R;
import aprivate.mo.tide.bean.TideUser;
import aprivate.mo.tide.provider.BombContentProvider;
import aprivate.mo.tide.ui.MainActivity;
import aprivate.mo.tide.utils.TideMessage;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import io.reactivex.functions.Consumer;
import privat.mo.tidelib.base.BaseActivity;

public class LoginActivity extends BaseActivity<ILoginActivityView, LoginActivityPresenter> implements ILoginActivityView {

    private Button btnLogin;
    private Button btnRegister;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        btnLogin = (Button) findViewById(R.id.btn_login_login);
        btnRegister = (Button) findViewById(R.id.btn_login_register);

        // 登陆
        RxView.clicks(btnLogin)
                .throttleFirst(5, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {

                        View loginView = LayoutInflater.from(LoginActivity.this).inflate(R.layout.dialog_login, null);
                        EditText etAccount = loginView.findViewById(R.id.et_login_account);
                        EditText etPassword = loginView.findViewById(R.id.et_login_password);


                        builder = new AlertDialog.Builder(LoginActivity.this)
                                .setTitle("登陆")
                                .setIcon(R.drawable.ic_logo_black)
                                .setView(loginView)
                                .setPositiveButton("完成", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        getPresenter().login(etAccount.getText().toString(), etPassword.getText().toString());
                                    }
                                });

                        builder.create().show();

                    }
                });

        // 注册
        RxView.clicks(btnRegister)
                .throttleFirst(5, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {

                        View registerView = LayoutInflater.from(LoginActivity.this).inflate(R.layout.dialog_register, null);
                        EditText etAccount = registerView.findViewById(R.id.et_register_account);
                        EditText etPassword = registerView.findViewById(R.id.et_register_password);
                        EditText etUserName = registerView.findViewById(R.id.et_register_username);

                        builder = new AlertDialog.Builder(LoginActivity.this)
                                .setTitle("注册")
                                .setIcon(R.drawable.ic_logo_black)
                                .setView(registerView)
                                .setPositiveButton("完成", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        if (TextUtils.isEmpty(etAccount.getText().toString())
                                                || TextUtils.isEmpty(etPassword.getText().toString())
                                                || TextUtils.isEmpty(etUserName.getText().toString())) {
                                            TideMessage.showMessage("所有待填项不能为空！");
                                            return;
                                        }
                                        TideUser user = new TideUser();
                                        user.setAccount(etAccount.getText().toString());
                                        user.setPassword(etPassword.getText().toString());
                                        user.setUserName(etUserName.getText().toString());
                                        user.save(new SaveListener<String>() {
                                            @Override
                                            public void done(String objectId, BmobException e) {
                                                if(e == null){
                                                    user.setObjectId(objectId);
                                                    TideMessage.showMessage("注册成功！");
                                                }else{
                                                    TideMessage.showMessage("注册失败：" + e.getMessage());
                                                }
                                            }
                                        });
                                    }
                                });

                        builder.create().show();
                    }
                });
    }

    @Override
    public void loginSuccess(TideUser user) {
        Intent intentToHome = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intentToHome);
    }

    @Override
    public void loginFail() {
        TideMessage.showMessage("登陆失败");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginActivityPresenter createPresenter() {
        return new LoginActivityPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String tip) {

    }
}
