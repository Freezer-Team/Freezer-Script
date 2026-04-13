package nep.timeline.freezer.reflection;

import nep.timeline.cakereflection.CakeReflection;

public class ReflectionInit {
    public static void init(ClassLoader freezerClassLoader) {
        Log.clazz = CakeReflection.findClassIfExists("nep.timeline.freezer.core.scripts.shadow.LogShadow", freezerClassLoader);
        AppCache.clazz = CakeReflection.findClassIfExists("nep.timeline.freezer.core.scripts.shadow.AppCacheShadow", freezerClassLoader);
        MsgFreezer.clazz = CakeReflection.findClassIfExists("nep.timeline.freezer.core.scripts.shadow.MsgFreezerShadow", freezerClassLoader);
        ProcessList.clazz = CakeReflection.findClassIfExists("nep.timeline.freezer.core.scripts.shadow.ProcessListShadow", freezerClassLoader);
        UnfreezeService.clazz = CakeReflection.findClassIfExists("nep.timeline.freezer.core.scripts.shadow.UnfreezeServiceShadow", freezerClassLoader);
    }
}
