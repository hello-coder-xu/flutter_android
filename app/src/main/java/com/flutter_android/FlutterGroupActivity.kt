package com.flutter_android

import android.content.Context
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import java.util.*

class FlutterGroupActivity : FlutterActivity(), EngineBindingsDelegate {

    private val engineBindings: EngineBindings by lazy {
        EngineBindings(
            activity = this,
            delegate = this,
            entrypoint = "main",
            initRoute = intent.getStringExtra("initRoute").toString()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        engineBindings.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        engineBindings.detach()
    }

    override fun provideFlutterEngine(context: Context): FlutterEngine? {
        return engineBindings.engine
    }

    override fun push(argument: Objects) {
        TODO("Not yet implemented")
    }

    override fun pop(argument: Objects) {
        TODO("Not yet implemented")
    }

    override fun even(argument: Objects) {
        TODO("Not yet implemented")
    }
}
