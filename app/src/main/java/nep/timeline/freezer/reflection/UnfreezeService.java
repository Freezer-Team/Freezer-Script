package nep.timeline.freezer.reflection;

import nep.timeline.cakereflection.CakeReflection;

public class UnfreezeService {
    public static Class<?> clazz;

    public static void thaw(AppRecord appRecord) {
        CakeReflection.callStaticMethod(clazz, "thaw", appRecord);
    }

    public static void thawWithCheck(AppRecord appRecord) {
        CakeReflection.callStaticMethod(clazz, "thawWithCheck", appRecord);
    }

    public static void thawWithoutRemoveMessage(AppRecord appRecord) {
        CakeReflection.callStaticMethod(clazz, "thawWithoutRemoveMessage", appRecord);
    }

    public static void temporaryUnfreezeIfNeed(AppRecord appRecord, String reason) {
        CakeReflection.callStaticMethod(clazz, "temporaryUnfreezeIfNeed", appRecord, reason);
    }

    public static void temporaryUnfreezeIfNeed(AppRecord appRecord, String reason, long interval) {
        CakeReflection.callStaticMethod(clazz, "temporaryUnfreezeIfNeed", appRecord, reason, interval);
    }
}
