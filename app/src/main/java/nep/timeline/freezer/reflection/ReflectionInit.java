package nep.timeline.freezer.reflection;

import de.robv.android.xposed.XposedHelpers;

public class ReflectionInit {
    public static void init(ClassLoader freezerClassLoader) {
        Log.clazz = XposedHelpers.findClassIfExists("nep.timeline.freezer.core.plugins.shadow.LogShadow", freezerClassLoader);
        AppCache.clazz = XposedHelpers.findClassIfExists("nep.timeline.freezer.core.plugins.shadow.AppCacheShadow", freezerClassLoader);
        MsgFreezer.clazz = XposedHelpers.findClassIfExists("nep.timeline.freezer.core.plugins.shadow.MsgFreezerShadow", freezerClassLoader);
        ProcessList.clazz = XposedHelpers.findClassIfExists("nep.timeline.freezer.core.plugins.shadow.ProcessListShadow", freezerClassLoader);
        UnfreezeService.clazz = XposedHelpers.findClassIfExists("nep.timeline.freezer.core.plugins.shadow.UnfreezeServiceShadow", freezerClassLoader);
    }
}
