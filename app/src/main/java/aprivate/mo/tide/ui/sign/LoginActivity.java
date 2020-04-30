package aprivate.mo.tide.ui.sign;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import aprivate.mo.tide.R;

import aprivate.mo.tide.ui.MainActivity;
import com.jakewharton.rxbinding2.view.RxView;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import privat.mo.tidelib.base.BaseActivity;

public class LoginActivity extends BaseActivity<ILoginActivityView, LoginActivityPresenter> implements ILoginActivityView {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnLogin = (Button) findViewById(R.id.btn_login_login);
        RxView.clicks(btnLogin)
            .throttleFirst(3, TimeUnit.SECONDS)
            .subscribe(new Consumer<Object>() {
                @Override
                public void accept(Object o) throws Exception {
                    Intent intentToHome = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intentToHome);
                }
            });

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
