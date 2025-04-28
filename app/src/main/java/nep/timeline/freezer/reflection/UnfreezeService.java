package nep.timeline.freezer.reflection;

import de.robv.android.xposed.XposedHelpers;

public class UnfreezeService {
    public static Class<?> clazz;

    public static void thaw(AppRecord appRecord) {
        XposedHelpers.callStaticMethod(clazz, "thaw", appRecord);
    }

    public static void thawWithCheck(AppRecord appRecord) {
        XposedHelpers.callStaticMethod(clazz, "thawWithCheck", appRecord);
    }

    public static void thawWithoutRemoveMessage(AppRecord appRecord) {
        XposedHelpers.callStaticMethod(clazz, "thawWithoutRemoveMessage", appRecord);
    }

    public static void temporaryUnfreezeIfNeed(AppRecord appRecord, String reason) {
        XposedHelpers.callStaticMethod(clazz, "temporaryUnfreezeIfNeed", appRecord, reason);
    }

    public static void temporaryUnfreezeIfNeed(AppRecord appRecord, String reason, long interval) {
        XposedHelpers.callStaticMethod(clazz, "temporaryUnfreezeIfNeed", appRecord, reason, interval);
    }
}
