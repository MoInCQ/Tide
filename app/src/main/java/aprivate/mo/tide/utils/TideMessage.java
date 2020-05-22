package aprivate.mo.tide.utils;

import android.text.TextUtils;
import android.widget.Toast;

import aprivate.mo.tide.app.TideApplication;
import privat.mo.tidelib.utils.ToastHelper;

/**
 * Created by Mo on 2020/5/22
 */

public class TideMessage {

    public static void showMessage(String message) {
        showMessage(message, Toast.LENGTH_SHORT);
    }

    public static void showMessage(String message, int during) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        ToastHelper.makeMessage(TideApplication.getContext(), message, during).show();
    }

}