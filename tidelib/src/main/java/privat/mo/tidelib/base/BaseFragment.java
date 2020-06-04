package privat.mo.tidelib.base;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import me.yokeyword.fragmentation.SupportFragment;
import privat.mo.tidelib.mvp.BasePresenter;
import privat.mo.tidelib.mvp.IView;

/**
 * Created by Mo on 2020/1/13
 */

public abstract class BaseFragment<V extends IView, P extends BasePresenter<V>> extends SupportFragment {

    protected P mPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutResId(), container, false);

        mPresenter = createPresenter();
        mPresenter.takeView((V) this);


        initView(view);
        initData();

        // 注册EventBus
        EventBus.getDefault().register(this);

        return view;
    }

    /**
     * 获取当前Fragment的Layout资源ID
     *
     * @return layoutId int
     */
    protected abstract int getLayoutResId();

    /**
     * 用于创建与当前Fragment相对应的Presenter
     *
     * @return p P extend BasePresenter
     */
    protected abstract P createPresenter();


    /**
     * 获取当前Fragment 的 Presenter实例
     *
     * @return mPresenter
     */
    public P getPresenter() {
        return mPresenter;
    }

    /**
     * 数据初始化入口
     */
    protected abstract void initData();

    /**
     * View初始化入口
     *
     * @param view
     */
    protected abstract void initView(View view);

    /**
     * 释放 View 与 Presenter 的相互引用
     */
    @Override
    public void onDestroy() {

        if (mPresenter != null) {
            mPresenter.dropView();
            mPresenter = null;
        }

        super.onDestroy();

        // 解注册EventBus
        EventBus.getDefault().unregister(this);
    }


    /**
     * 空实现完成对EventBus的封装
     */
    @Subscribe
    public void onEvent(Message message){
    }
}
