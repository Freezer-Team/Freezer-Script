# Freezer 开发接口

### 待更新中
Freezer 已更新为 API 101, 文档内容待更新

## 脚本位置
脚本应该存放在 `data/system/Freezer/scripts` 文件夹中.

## 外部依赖库
Freezer本体已导入以下第三方依赖库:
```
com.google.code.gson
commons-io
dev.rikka.rikkax.parcelablelist
org.lsposed.hiddenapibypass
com.github.topjohnwu.libsu:core
com.github.topjohnwu.libsu:service
com.github.topjohnwu.libsu:io
```
如果你的脚本使用了上述第三方依赖库中的其中一个 请确保不要将依赖库打包至脚本中 使用 `compileOnly` 即可.

## 开始
当前 Freezer 开发接口 提供了7个来自Freezer本体的反射类
它们分别是:
```
AppCache
AppRecord
Log
MsgFreezer
ProcessList
ProcessRecord
UnfreezeService
```
它们的作用分别是:
```
AppCache: 检索被Freezer缓存的应用记录
AppRecord: 存储应用程序基本数据
Log: 用于输出日志
MsgFreezer: 用于发送冻结请求
UnfreezeService: 用于发送解冻请求
ProcessList: 检索被Freezer缓存的进程记录
ProcessRecord: 存储进程基本数据
```

## 小试牛刀
首先，你需要将这个项目导入到Android Studio中
然后转到 nep.timeline.freezer.EntryPoint 这个类
__这个类的位置不可以被变更！__

接下来 让我们看看init方法体
```
public static void init(ClassLoader targetClassLoader, ClassLoader freezerClassLoader) {
    GlobalData.targetClassLoader = targetClassLoader;
    GlobalData.freezerClassLoader = freezerClassLoader;
    ReflectionInit.init(freezerClassLoader);
}
```
freezerClassLoader并不重要，无视即可

**这个项目默认已导入Xposed API，接下来 让我们尝试Hook方法吧**
例如: 我需要阻止Android CachedAppOptimizer冻结应用, 所以我们需要通过Hook拦截它。
CachedAppOptimizer类的位置在: `com/android/server/am/CachedAppOptimizer`
这个类中有一个 `useFreezer` 方法，我们只需要Hook它并让他返回false即可

代码 (Java):
```Java
XposedHelpers.findAndHookMethod("com.android.server.am.CachedAppOptimizer", targetClassLoader, "useFreezer", XC_MethodReplacement.returnConstant(false));
```

好的，接下来我需要检测服务执行时解冻应用程序
要实现它, 只需要Hook在 `com/android/server/am/ActiveServices` 中的 `bumpServiceExecutingLocked` 方法即可

代码 (Java):
```Java
XposedHelpers.findAndHookMethod("com.android.server.am.ActiveServices", targetClassLoader, "bumpServiceExecutingLocked", "com.android.server.am.ServiceRecord", boolean.class, String.class, int.class, boolean.class, new XC_MethodHook() {
    @Override
    protected void beforeHookedMethod(MethodHookParam param) {
        Object service = param.args[0];
        if (service == null)
            return;

        ProcessRecord processRecord = ProcessList.getProcessRecord(XposedHelpers.getObjectField(service, "app"));
        if (processRecord == null)
            return;

        UnfreezeService.temporaryUnfreezeIfNeed(processRecord.getAppRecord(), "SERVICE");
    }
});
```

## 构建
你可以通过 `./gradlew build` 命令来构建你编写的脚本
然后，你应该能够在项目根目录下的 `\app\build\outputs\apk\release` 文件夹中找到编译后的脚本

你可以看到编译后的文件是一个apk文件。接下来，你需要解压缩它以提取 `classes.dex` 文件并将其打包为jar文件

然后，你只需将jar文件放入Freezer插件文件夹中即可。

__以上是 `Freezer 开发接口` 的基本使用方法。我们希望你可以使用这个API来开发一些有趣的功能__
