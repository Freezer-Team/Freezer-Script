package nep.timeline.freezer.reflection;

import nep.timeline.cakereflection.CakeReflection;

public class AppCache {
    public static Class<?> clazz;

    public static AppRecord get(String packageName, int userId) {
        Object appRecord = CakeReflection.callStaticMethod(clazz, "get", packageName, userId);
        if (appRecord == null)
            return null;
        return new AppRecord(appRecord);
    }

    public static AppRecord getByUid(int uid) {
        Object appRecord = CakeReflection.callStaticMethod(clazz, "getByUid", uid);
        if (appRecord == null)
            return null;
        return new AppRecord(appRecord);
    }
}
