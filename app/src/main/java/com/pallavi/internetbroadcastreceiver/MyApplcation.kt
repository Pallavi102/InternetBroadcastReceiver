package com.pallavi.internetbroadcastreceiver

import android.app.Application
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance


class MyApplcation:Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    fun setConnectionListener(listener: ConnectionReceiver.ConnectionReceiverListener)
    {
        ConnectionReceiver.connectionReceiverListener = listener
    }
companion object {
    @get:Synchronized
    lateinit var instance: MyApplcation
}

}
