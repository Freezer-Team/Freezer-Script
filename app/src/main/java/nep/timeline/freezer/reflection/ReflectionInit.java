package nep.timeline.freezer.reflection;

import de.robv.android.xposed.XposedHelpers;

public class ReflectionInit {
    public static void init(ClassLoader freezerClassLoader) {
        Log.clazz = XposedHelpers.findClassIfExists("nep.timeline.freezer.core.scripts.shadow.LogShadow", freezerClassLoader);
        AppCache.clazz = XposedHelpers.findClassIfExists("nep.timeline.freezer.core.scripts.shadow.AppCacheShadow", freezerClassLoader);
        MsgFreezer.clazz = XposedHelpers.findClassIfExists("nep.timeline.freezer.core.scripts.shadow.MsgFreezerShadow", freezerClassLoader);
        ProcessList.clazz = XposedHelpers.findClassIfExists("nep.timeline.freezer.core.scripts.shadow.ProcessListShadow", freezerClassLoader);
        UnfreezeService.clazz = XposedHelpers.findClassIfExists("nep.timeline.freezer.core.scripts.shadow.UnfreezeServiceShadow", freezerClassLoader);
    }
}
