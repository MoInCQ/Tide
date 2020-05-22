package aprivate.mo.tide.app;

import android.app.Application;
import android.content.Context;

import cn.bmob.v3.Bmob;
import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;

/**
 * Created by Mo on 2020/1/13
 */

public class TideApplication extends Application{

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();


        // 悬浮球现实栈视图
        Fragmentation.builder()
                // 设置 栈视图 模式为 （默认）悬浮球模式   SHAKE: 摇一摇唤出  NONE：隐藏， 仅在Debug环境生效
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(true)
                .handleException(new ExceptionHandler() {
                    @Override
                    public void onException(Exception e) {
                        // 以Bugtags为例子: 把捕获到的 Exception 传到 Bugtags 后台。
                        // Bugtags.sendException(e);
                    }
                })
                .install();

        // 初始化Bomb
        Bmob.initialize(this, "c5280556bfc6ccbe7a0bb08cf99adaf9");
    }

    /**
     * 获取全局Context
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }
}
