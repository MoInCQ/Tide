package privat.mo.tidelib.Utils;

import android.content.Context;
import android.content.res.Resources;

/**
 * 状态栏工具类
 */
public class SystemBarUtil {

  private static int getStatusBarHeight(Context context) {
    int statusBarHeight = 0;
    Resources res = context.getResources();
    int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0) {
      statusBarHeight = res.getDimensionPixelSize(resourceId);
    }
    return statusBarHeight;
  }

}
