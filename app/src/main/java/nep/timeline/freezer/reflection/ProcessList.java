package nep.timeline.freezer.reflection;

import nep.timeline.cakereflection.CakeReflection;

public class ProcessList {
    public static Class<?> clazz;

    public static ProcessRecord getProcessRecord(String processName, int uid) {
        Object processRecord = CakeReflection.callStaticMethod(clazz, "getProcessRecord", processName, uid);
        if (processRecord == null)
            return null;
        return new ProcessRecord(processRecord);
    }

    public static ProcessRecord getProcessRecord(Object instance) {
        Object processRecord = CakeReflection.callStaticMethod(clazz, "getProcessRecord", instance);
        if (processRecord == null)
            return null;
        return new ProcessRecord(processRecord);
    }

    public static ProcessRecord getProcessRecordFromPid(int pid) {
        Object processRecord = CakeReflection.callStaticMethod(clazz, "getProcessRecordFromPid", pid);
        if (processRecord == null)
            return null;
        return new ProcessRecord(processRecord);
    }
}
