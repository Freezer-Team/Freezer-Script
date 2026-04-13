package nep.timeline.freezer.reflection;

import android.content.pm.ApplicationInfo;

import nep.timeline.cakereflection.CakeReflection;

public class AppRecord {
    private final Object instance;
    private final String packageName;
    private final int userId;

    public AppRecord(Object instance) {
        this.instance = instance;
        this.packageName = (String) CakeReflection.callMethod(instance, "getPackageName");
        this.userId = (int) CakeReflection.callMethod(instance, "getUserId");
    }

    public String getPackageName() {
        return packageName;
    }

    public int getUserId() {
        return userId;
    }

    public int getUid() {
        return (int) CakeReflection.callMethod(instance, "getUid");
    }

    public ApplicationInfo getApplicationInfo() {
        return (ApplicationInfo) CakeReflection.callMethod(instance, "getApplicationInfo");
    }
}
