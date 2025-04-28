package nep.timeline.freezer.reflection;

import de.robv.android.xposed.XposedHelpers;

public class ProcessList {
    public static Class<?> clazz;

    public static ProcessRecord getProcessRecord(String processName, int uid) {
        Object processRecord = XposedHelpers.callStaticMethod(clazz, "getProcessRecord", processName, uid);
        if (processRecord == null)
            return null;
        return new ProcessRecord(processRecord);
    }

    public static ProcessRecord getProcessRecord(Object instance) {
        Object processRecord = XposedHelpers.callStaticMethod(clazz, "getProcessRecord", instance);
        if (processRecord == null)
            return null;
        return new ProcessRecord(processRecord);
    }

    public static ProcessRecord getProcessRecordFromPid(int pid) {
        Object processRecord = XposedHelpers.callStaticMethod(clazz, "getProcessRecordFromPid", pid);
        if (processRecord == null)
            return null;
        return new ProcessRecord(processRecord);
    }
}
