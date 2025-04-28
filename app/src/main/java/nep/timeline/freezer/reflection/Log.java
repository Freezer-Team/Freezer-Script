package nep.timeline.freezer.reflection;

import de.robv.android.xposed.XposedHelpers;

public class Log {
    public static Class<?> clazz;

    public static void d(String msg) {
        XposedHelpers.callStaticMethod(clazz, "d", msg);
    }

    public static void d(String msg, Throwable throwable) {
        XposedHelpers.callStaticMethod(clazz, "d", msg, throwable);
    }

    public static void i(String msg) {
        XposedHelpers.callStaticMethod(clazz, "i", msg);
    }

    public static void w(String msg) {
        XposedHelpers.callStaticMethod(clazz, "w", msg);
    }

    public static void w(String msg, Throwable throwable) {
        XposedHelpers.callStaticMethod(clazz, "w", msg, throwable);
    }

    public static void e(String msg) {
        XposedHelpers.callStaticMethod(clazz, "e", msg);
    }

    public static void e(String msg, Throwable throwable) {
        XposedHelpers.callStaticMethod(clazz, "e", msg, throwable);
    }
}
