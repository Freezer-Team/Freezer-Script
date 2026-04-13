package nep.timeline.freezer;

import org.jetbrains.annotations.Nullable;

import io.github.libxposed.api.XposedModule;
import nep.timeline.cakereflection.CakeHooker;
import nep.timeline.freezer.reflection.ReflectionInit;
import nep.timeline.freezer.script.BuildConfig;

public class EntryPoint {
    public static final String scriptName = "Demo";
    public static final String developerName = "Timeline";
    public static final String versionName = BuildConfig.VERSION_NAME;
    public static final int versionCode = BuildConfig.VERSION_CODE;
    public static final String description = "Demo";

    public static void init(ClassLoader targetClassLoader, ClassLoader freezerClassLoader, @Nullable XposedModule module) {
        // 加载反射 不要动这里
        GlobalData.targetClassLoader = targetClassLoader; // 系统框架 ClassLoader
        GlobalData.freezerClassLoader = freezerClassLoader; // Freezer 内部 ClassLoader
        CakeHooker.setXposedModule(module);
        ReflectionInit.init(freezerClassLoader);

        // 执行你的代码
    }
}
