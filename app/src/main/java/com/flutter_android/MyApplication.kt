package com.flutter_android

import android.app.Application
import io.flutter.embedding.engine.FlutterEngineGroup

class MyApplication : Application() {
    companion object {
        lateinit var context: Application;
    }


    //flutter 引擎组
    lateinit var flutterEngineGroup: FlutterEngineGroup

    override fun onCreate() {
        super.onCreate()
        context = this;
        flutterEngineGroup = FlutterEngineGroup(this)
    }
}