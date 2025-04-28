package nep.timeline.freezer.reflection;

import de.robv.android.xposed.XposedHelpers;

public class AppCache {
    public static Class<?> clazz;

    public static AppRecord get(String packageName, int userId) {
        Object appRecord = XposedHelpers.callStaticMethod(clazz, "get", packageName, userId);
        if (appRecord == null)
            return null;
        return new AppRecord(appRecord);
    }

    public static AppRecord getByUid(int uid) {
        Object appRecord = XposedHelpers.callStaticMethod(clazz, "getByUid", uid);
        if (appRecord == null)
            return null;
        return new AppRecord(appRecord);
    }
}
