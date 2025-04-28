# Open Freezer API

## Plugin location
Plugin should stored in `data/system/Freezer/plugins` folder.

## External dependency library
Third party libraries referenced by Freezer:
```
com.google.code.gson
commons-io
dev.rikka.rikkax.parcelablelist
org.lsposed.hiddenapibypass
com.github.topjohnwu.libsu:core
com.github.topjohnwu.libsu:service
com.github.topjohnwu.libsu:io
```
If the script you write requires the use of these third-party dependency libraries, please do not package them into your plugin and use `compileOnly` instead.

## Start
Currently, the Open Freezer SDK provides 7 reflection classes from Freezer
They are respectively:
```
AppCache
AppRecord
Log
MsgFreezer
ProcessList
ProcessRecord
UnfreezeService
```
Their functions are respectively:
```
AppCache: Retrieve application record cached in Freezer
AppRecord: Stores the basic data of the application
Log: Used to output logs
MsgFreezer: Used to send freeze requests
UnfreezeService: Used to send thaw requests
ProcessList: Retrieve process record cached in Freezer
ProcessRecord: Stores the basic data of the process
```

## Let's give it a try
First, import this project using Android Studio.
Then go to nep.timeline.freezer.EntryPoint class.
__The position of this class cannot be changed!__

Let's take a look at the init method
```
public static void init(ClassLoader targetClassLoader, ClassLoader freezerClassLoader) {
    GlobalData.targetClassLoader = targetClassLoader;
    GlobalData.freezerClassLoader = freezerClassLoader;
    ReflectionInit.init(freezerClassLoader);
}
```
freezerClassLoader is not important, just ignore it.

**This project defaults to importing the Xposed API. Next, let's try hooking a method**
For example, I need to block Android's CachedAppOptimizer from freezing applications, so I need to intercept it
Its location is: `com/android/server/am/CachedAppOptimizer`
Then there is a `useFreezer` method in this class, just hook it and let it return false

Code (Java):
```Java
XposedHelpers.findAndHookMethod("com.android.server.am.CachedAppOptimizer", targetClassLoader, "useFreezer", XC_MethodReplacement.returnConstant(false));
```

Okay, next I need to unfreeze the application bump service executing
To implement it, simply hook the `bumpServiceExecutingLocked` method in `com/android/server/am/ActiveServices`

Code (Java):
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

## Build
You can use `./gradlew build` to build the script you have written
Then you should be able to find the compiled script in the `\app\build\outputs\apk\release` folder under the project root directory
You can see that the compiled file is an apk file. Next, you need to unzip it to extract the `classes.dex` file and package it into a jar file
Then you just need to put the jar file into the Freezer plugins folder.

__The above is the basic usage method of the `Open Freezer API`. We hope you can use this API to develop interesting features__