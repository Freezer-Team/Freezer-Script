package nep.timeline.freezer;

import nep.timeline.freezer.reflection.ReflectionInit;
import nep.timeline.freezer.script.BuildConfig;

public class EntryPoint {
    public static final String scriptName = "Demo";
    public static final String developerName = "Timeline";
    public static final String versionName = BuildConfig.VERSION_NAME;
    public static final int versionCode = BuildConfig.VERSION_CODE;
    public static final String description = "Demo";

    public static void init(ClassLoader targetClassLoader, ClassLoader freezerClassLoader) {
        // 加载反射 不要动这里
        GlobalData.targetClassLoader = targetClassLoader; // 系统框架 ClassLoader
        GlobalData.freezerClassLoader = freezerClassLoader; // Freezer 内部 ClassLoader
        ReflectionInit.init(freezerClassLoader);

        // 执行你的代码
    }
}
