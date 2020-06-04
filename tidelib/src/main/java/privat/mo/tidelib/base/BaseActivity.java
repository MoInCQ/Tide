package privat.mo.tidelib.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import me.yokeyword.fragmentation.SupportActivity;
import privat.mo.tidelib.mvp.BasePresenter;
import privat.mo.tidelib.mvp.IView;

/**
 * Created by Mo on 2020/1/13
 */

public abstract class BaseActivity<V extends IView, P extends BasePresenter<V>> extends SupportActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置状态栏：沉浸模式
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int option =  View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            window.getDecorView().setSystemUiVisibility(option);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }



        setContentView(getLayoutResId());


        // 实例化View对应的Presenter
        mPresenter = createPresenter();
        // 获取View
        mPresenter.takeView((V) this);

        // 注册EventBus
        EventBus.getDefault().register(this);
    }


    /**
     * 释放 View 与 Presenter 的相互引用
     */
    @Override
    protected void onDestroy() {

        if (mPresenter != null) {
            mPresenter.dropView();
            mPresenter = null;
        }

        super.onDestroy();

        // 解注册EventBus
        EventBus.getDefault().unregister(this);
    }


    /**
     * 获取当前Activity的Layout资源
     *
     * @return layoutId int
     */
    protected abstract int getLayoutResId();


    /**
     * 为当前 View（Activity）创建 Presenter 实例
     *
     * @return presenter P extend BasePresenter
     */
    protected abstract P createPresenter();


    /**
     * 获取当前 Activity 的 Presenter实例
     *
     * @return mPresenter
     */
    protected P getPresenter () {
        return mPresenter;
    }

    /**
     * 空实现完成对EventBus的封装
     */
    @Subscribe
    public void onEvent(Message message){
    }


}
