package nep.timeline.freezer.reflection;

import android.content.pm.ApplicationInfo;

import nep.timeline.cakereflection.CakeReflection;

public class ProcessRecord {
    private final Object instance;
    private final ApplicationInfo applicationInfo;
    private final String packageName;
    private final String processName;
    private final String processNameWithIsolated;
    private final int userId;
    private final int uid;
    private final int runningUid;

    public ProcessRecord(Object instance) {
        this.instance = instance;
        this.applicationInfo = (ApplicationInfo) CakeReflection.callMethod(instance, "getApplicationInfo");
        this.packageName = (String) CakeReflection.callMethod(instance, "getPackageName");
        this.processName = (String) CakeReflection.callMethod(instance, "getProcessName");
        this.processNameWithIsolated = (String) CakeReflection.callMethod(instance, "getProcessNameWithIsolated");
        this.userId = (int) CakeReflection.callMethod(instance, "getUserId");
        this.uid = (int) CakeReflection.callMethod(instance, "getUid");
        this.runningUid = (int) CakeReflection.callMethod(instance, "getRunningUid");
    }

    public String getPackageName() {
        return packageName;
    }

    public int getUserId() {
        return userId;
    }

    /** 与 AppRecord 中的 UID 相等 **/
    public int getUid() {
        return uid;
    }

    /** 理论上它与 getUid 的结果相同 但是如果ProcessRecord是一个Isolated进程的话 比如WebView 则指向比如WebView的PID **/
    public int getRunningUid() {
        return runningUid;
    }

    public String getProcessName() {
        return processName;
    }

    /** 如果进程不是一个Isolated进程的话 与 getProcessName 结果相等 **/
    public String getProcessNameWithIsolated() {
        return processNameWithIsolated;
    }

    public AppRecord getAppRecord() {
        Object appRecord = CakeReflection.callMethod(instance, "getAppRecord");
        if (appRecord == null)
            return null;
        return new AppRecord(appRecord);
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }
}
