package com.pallavi.internetbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class ConnectionReceiver():BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val isConnection = checkConnection(context)
        if (connectionReceiverListener!= null)
            connectionReceiverListener!!.onNetworkConnectionChanged(isConnected)

    }
    interface ConnectionReceiverListener{
        fun onNetworkConnectionChanged(isConnected:Boolean)
    }
    companion object
    {
        var connectionReceiverListener: ConnectionReceiverListener? = null
        val isConnected:Boolean
        get() {

            val connectivityManager = MyApplcation.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = connectivityManager.activeNetworkInfo
            return (activeNetwork!=null &&activeNetwork.isConnectedOrConnecting)
        }
    }

    private fun checkConnection(context: Context?): Boolean {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return (activeNetwork!=null &&activeNetwork.isConnectedOrConnecting)

    }
}

