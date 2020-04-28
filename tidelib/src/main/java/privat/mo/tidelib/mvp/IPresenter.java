package privat.mo.tidelib.mvp;

/**
 * Created by Mo on 2020/1/13
 */

public interface IPresenter<V> {

    /**
     * @param view 和presenter相绑定的view
     */
    void takeView(V view);


    /**
     * 当view destroy的时候，调用presenter的这个方法，presenter释放对view的引用，从而避免内存泄露问题
     */
    void dropView();


    /**
     * 用于 Presenter 获取View，对View 层进行操作
     * @return V
     */
    V getView();
}
