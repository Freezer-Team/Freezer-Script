package nep.timeline.freezer.reflection;

import android.content.pm.ApplicationInfo;

import de.robv.android.xposed.XposedHelpers;

public class AppRecord {
    private final Object instance;
    private final String packageName;
    private final int userId;

    public AppRecord(Object instance) {
        this.instance = instance;
        this.packageName = (String) XposedHelpers.callMethod(instance, "getPackageName");
        this.userId = (int) XposedHelpers.callMethod(instance, "getUserId");
    }

    public String getPackageName() {
        return packageName;
    }

    public int getUserId() {
        return userId;
    }

    public int getUid() {
        return (int) XposedHelpers.callMethod(instance, "getUid");
    }

    public ApplicationInfo getApplicationInfo() {
        return (ApplicationInfo) XposedHelpers.callMethod(instance, "getApplicationInfo");
    }
}
