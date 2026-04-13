package nep.timeline.freezer.reflection;

import nep.timeline.cakereflection.CakeReflection;

public class Log {
    public static Class<?> clazz;

    public static void d(String msg) {
        CakeReflection.callStaticMethod(clazz, "d", msg);
    }

    public static void d(String msg, Throwable throwable) {
        CakeReflection.callStaticMethod(clazz, "d", msg, throwable);
    }

    public static void i(String msg) {
        CakeReflection.callStaticMethod(clazz, "i", msg);
    }

    public static void w(String msg) {
        CakeReflection.callStaticMethod(clazz, "w", msg);
    }

    public static void w(String msg, Throwable throwable) {
        CakeReflection.callStaticMethod(clazz, "w", msg, throwable);
    }

    public static void e(String msg) {
        CakeReflection.callStaticMethod(clazz, "e", msg);
    }

    public static void e(String msg, Throwable throwable) {
        CakeReflection.callStaticMethod(clazz, "e", msg, throwable);
    }
}
