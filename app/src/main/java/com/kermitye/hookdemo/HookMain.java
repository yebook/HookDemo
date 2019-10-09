package com.kermitye.hookdemo;

import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

// Created by kermitye on 2019/7/16 15:37
public class HookMain implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.qwtnet.video")) return;
        Log.e("kermitye", "======进入到Hook方法里了");

        /*XposedHelpers.findAndHookMethod("com.kermitye.hookdemo.MainActivity", lpparam.classLoader, "getInfoText", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult("小样，我破解成功了！！");
            }
        });*/

        Class Builder = lpparam.classLoader.loadClass("okhttp3.OkHttpClient$Builder");
        Class Proxy = lpparam.classLoader.loadClass("java.net.Proxy");
        XposedHelpers.findAndHookMethod(Builder,
                "proxy",
                Proxy,
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                        return methodHookParam.thisObject;
                    }
                });
    }
}
