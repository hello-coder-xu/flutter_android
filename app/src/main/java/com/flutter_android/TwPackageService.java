package com.flutter_android;

import android.content.Context;
import android.content.pm.PackageManager;

public class TwPackageService {

    //通过包名找应用
    private boolean hasPackage(String pkgName) {
        Context context = MainActivity.context;
        if (null == context || null == pkgName) {
            return false;
        }
        boolean bHas = true;
        try {
            context.getPackageManager().getPackageInfo(pkgName, PackageManager.GET_GIDS);
        } catch (PackageManager.NameNotFoundException e) {
            // 抛出找不到的异常，说明该程序已经被卸载
            bHas = false;
        }
        return bHas;
    }
}
