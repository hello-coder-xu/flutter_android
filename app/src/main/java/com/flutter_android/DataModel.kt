package com.flutter_android

import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.ref.WeakReference


interface DataModelObserver {
    fun onCountUpdate(newCount: Int)
}


class DataModel {
    companion object {
        val instance = DataModel()
    }

    private val observers = mutableListOf<WeakReference<DataModelObserver>>()

    public var counter = 0
        set(value) {
            field = value
            for (observer in observers) {
                observer.get()?.onCountUpdate(value)
            }
        }

    fun addObserver(observer: DataModelObserver) {
        observers.add(WeakReference(observer))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun removeObserver(observer: DataModelObserver) {
        observers.removeIf {
            if (it.get() != null) it.get() == observer else true
        }
    }
}
