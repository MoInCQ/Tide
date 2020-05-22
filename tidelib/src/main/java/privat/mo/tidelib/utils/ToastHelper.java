package privat.mo.tidelib.utils;

import android.content.Context;
import android.support.annotation.IntDef;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Mo on 2020/5/22
 */

public class ToastHelper {

    private static volatile Toast toast;
    static final int LENGTH_SHORT = 0;
    static final int LENGTH_LONG = 1;

    @IntDef({LENGTH_SHORT, LENGTH_LONG})
    @Retention(RetentionPolicy.SOURCE)
    @interface Duration {}


    public static Toast makeMessage(Context context, CharSequence text, @Duration int duration) {
        if (toast == null) {
            synchronized (ToastHelper.class) {
                if (toast == null) {
                    toast = Toast.makeText(context, text, duration);
                }
            }
        }
        toast.setDuration(duration);
        toast.setText(text);
        return toast;
    }

}