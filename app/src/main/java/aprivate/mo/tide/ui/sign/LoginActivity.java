package aprivate.mo.tide.ui.sign;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import aprivate.mo.tide.R;

import aprivate.mo.tide.ui.MainActivity;
import privat.mo.tidelib.base.BaseActivity;

public class LoginActivity extends BaseActivity<ILoginActivityView, LoginActivityPresenter> implements ILoginActivityView {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnLogin = (Button) findViewById(R.id.btn_login_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
