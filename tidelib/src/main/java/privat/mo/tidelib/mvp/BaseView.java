package privat.mo.tidelib.mvp;



/**
 * Created by Mo on 2020/1/13
 *
 *
 */

public interface BaseView extends IView {

    /**
     * 页面显示加载画面
     */
    void showLoading();

    /**
     * 页面隐藏加载画面
     */
    void hideLoading();

    /**
     * 页面显示提示（如 空数据、加载超时等）
     *
     * @param tip String
     */
    void showToast(String tip);

}
