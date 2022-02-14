package com.flutter_android

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import io.flutter.plugin.common.MethodChannel
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.dart.DartExecutor
import java.util.*

interface EngineBindingsDelegate {
    // 页面跳转
    fun push(argument: Objects)

    // 页面关闭
    fun pop(argument: Objects)

    // 事件方法
    fun even(argument: Objects)
}

class EngineBindings(
    activity: Activity, delegate: EngineBindingsDelegate, entrypoint: String,
    initRoute: String
) : DataModelObserver {
    private val channel: MethodChannel
    val engine: FlutterEngine
    private val delegate: EngineBindingsDelegate

    init {
        println("test EngineBindings init")
        val app = activity.applicationContext as MyApplication
        // This has to be lazy to avoid creation before the FlutterEngineGroup.
        val dartEntrypoint = DartExecutor.DartEntrypoint(
            FlutterInjector.instance().flutterLoader().findAppBundlePath(), entrypoint
        )
        engine = app.flutterEngineGroup.createAndRunEngine(activity, dartEntrypoint, initRoute)
        this.delegate = delegate
        channel = MethodChannel(engine.dartExecutor.binaryMessenger, "flutter_android")
    }

    /**
     * This setups the messaging connections on the platform channel and the DataModel.
     */
    fun attach() {
        DataModel.instance.addObserver(this)
        channel.invokeMethod("setCount", DataModel.instance.counter)
        channel.setMethodCallHandler { call, result ->
            when (call.method) {
                "event" -> {
                    this.delegate.even(call.arguments())
                    result.success(null)
                }
                "push" -> {
                    this.delegate.push(call.arguments())
                    result.success(null)
                }
                "pop" -> {
                    this.delegate.pop(call.arguments())
                    result.success(null)
                }
                else -> {
                    result.notImplemented()
                }
            }
        }
    }

    /**
     * This tears down the messaging connections on the platform channel and the DataModel.
     */
    fun detach() {
        engine.destroy();
        DataModel.instance.removeObserver(this)
        channel.setMethodCallHandler(null)
    }

    override fun onCountUpdate(newCount: Int) {
        channel.invokeMethod("setCount", newCount)
    }
}