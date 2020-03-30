package com.example.dagger

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(private  var engine: Engine, private  var wheels: Wheels) {

    @Inject
    fun enableRemote(remote: Remote) {
        remote.setListener(this)
    }

    fun drive() {
        engine.start()
        Log.e("Car", "driving.....")
    }
}