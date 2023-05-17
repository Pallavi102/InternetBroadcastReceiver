package com.pallavi.internetbroadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pallavi.internetbroadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),ConnectionReceiver.ConnectionReceiverListener {
    lateinit var binding: ActivityMainBinding
    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if (isConnected)
        {
            binding.connected.visibility = View.VISIBLE
            binding.notConnected.visibility = View.INVISIBLE
        }
        else
        {
            binding.connected.visibility = View.INVISIBLE
            binding.notConnected.visibility = View.VISIBLE
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        baseContext.registerReceiver(ConnectionReceiver(),IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        MyApplcation.instance.setConnectionListener(this)
    }
}

/*class MainActivity : AppCompatActivity().ConnectionReceiver.ConnectionReceiverListener {
    override fun onNetworkConnectionChanged(isConneted:Boolean)
    {
        is
    }
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

}*/

