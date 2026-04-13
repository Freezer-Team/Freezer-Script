package nep.timeline.freezer.reflection;

import nep.timeline.cakereflection.CakeReflection;

public class MsgFreezer {
    public static Class<?> clazz;

    public static void removeAppMessage(AppRecord appRecord) {
        CakeReflection.callStaticMethod(clazz, "removeAppMessage", appRecord);
    }

    public static void sendFreezeMessageInstant(AppRecord appRecord) {
        CakeReflection.callStaticMethod(clazz, "sendFreezeMessageInstant", appRecord);
    }

    public static void sendFreezeMessage(AppRecord appRecord) {
        CakeReflection.callStaticMethod(clazz, "sendFreezeMessage", appRecord);
    }

    public static void sendFreezeMessage(AppRecord appRecord, long interval) {
        CakeReflection.callStaticMethod(clazz, "sendFreezeMessage", appRecord, interval);
    }

    public static void sendFreezeMessageIgnoreMessages(AppRecord appRecord) {
        CakeReflection.callStaticMethod(clazz, "sendFreezeMessageIgnoreMessages", appRecord);
    }

    public static void sendFreezeMessageIgnoreMessages(AppRecord appRecord, long interval) {
        CakeReflection.callStaticMethod(clazz, "sendFreezeMessageIgnoreMessages", appRecord, interval);
    }
}
