package privat.mo.tidelib.Utils;

import android.content.res.Resources;
import android.util.TypedValue;

public class DenstinyUtil {

  public static int dpToPx(int dp) {
    return (int) TypedValue
        .applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
  }

  public static int pxToDp(float px) {
    return (int) TypedValue
        .applyDimension(TypedValue.COMPLEX_UNIT_PX, px, Resources.getSystem().getDisplayMetrics());
  }

}
