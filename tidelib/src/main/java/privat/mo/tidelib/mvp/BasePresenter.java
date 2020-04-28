package privat.mo.tidelib.mvp;

import java.lang.ref.WeakReference;


/**
 * Created by Mo on 2020/1/13
 */

public class BasePresenter<V extends IView> implements IPresenter<V> {

    /**
     * 对View 使用弱引用，防止内存泄漏
     */
    private WeakReference<V> viewReference;


    /**
     * 获取和presenter相绑定的view
     *
     * @param view
     */
    @Override
    public void takeView(V view) {
        viewReference = new WeakReference<V>(view);
    }


    /**
     * 当view destroy的时候，调用presenter的这个方法，presenter释放对view的引用，从而避免内存泄露问题
     */
    @Override
    public void dropView() {
        if (viewReference != null) {
            viewReference.clear();
            viewReference = null;
        }
    }


    /**
     * 获取 Presenter 对应的View
     *
     * @return V
     */
    @Override
    public V getView() {
        return viewReference == null ? null : viewReference.get();
    }
}
