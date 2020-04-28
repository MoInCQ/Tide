package aprivate.mo.tide.ui.explore.classify;

/**
 * Created by Mo on 2020/3/27
 */

public class SingleInstance {

    private SingleInstance() {
    }

//    public static SingleInstance getInstance() {
//        return SingleInstanceHolder.INSTANCE;
//    }
//
//    private static class SingleInstanceHolder {
//        private static final SingleInstance INSTANCE = new SingleInstance();
//    }

    private static volatile SingleInstance INSTANCE;

    public static SingleInstance getInstance() {
        if (INSTANCE == null) {
            synchronized (SingleInstance.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingleInstance();
                }
            }
        }
        return INSTANCE;
    }



}
