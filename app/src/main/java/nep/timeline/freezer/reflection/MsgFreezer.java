package nep.timeline.freezer.reflection;

import de.robv.android.xposed.XposedHelpers;

public class MsgFreezer {
    public static Class<?> clazz;

    public static void removeAppMessage(AppRecord appRecord) {
        XposedHelpers.callStaticMethod(clazz, "removeAppMessage", appRecord);
    }

    public static void sendFreezeMessageInstant(AppRecord appRecord) {
        XposedHelpers.callStaticMethod(clazz, "sendFreezeMessageInstant", appRecord);
    }

    public static void sendFreezeMessage(AppRecord appRecord) {
        XposedHelpers.callStaticMethod(clazz, "sendFreezeMessage", appRecord);
    }

    public static void sendFreezeMessage(AppRecord appRecord, long interval) {
        XposedHelpers.callStaticMethod(clazz, "sendFreezeMessage", appRecord, interval);
    }

    public static void sendFreezeMessageIgnoreMessages(AppRecord appRecord) {
        XposedHelpers.callStaticMethod(clazz, "sendFreezeMessageIgnoreMessages", appRecord);
    }

    public static void sendFreezeMessageIgnoreMessages(AppRecord appRecord, long interval) {
        XposedHelpers.callStaticMethod(clazz, "sendFreezeMessageIgnoreMessages", appRecord, interval);
    }
}
