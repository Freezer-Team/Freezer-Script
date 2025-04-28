package nep.timeline.freezer;

import nep.timeline.freezer.reflection.ReflectionInit;

public class EntryPoint {
    public static void init(ClassLoader targetClassLoader, ClassLoader freezerClassLoader) {
        // 加载反射 不要动这里
        GlobalData.targetClassLoader = targetClassLoader;
        GlobalData.freezerClassLoader = freezerClassLoader;
        ReflectionInit.init(freezerClassLoader);

        // 执行你的代码
    }
}
