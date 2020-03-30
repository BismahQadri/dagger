package com.example.dagger.car

import android.util.Log
import com.example.dagger.dagger.PerActivity
import javax.inject.Inject
@PerActivity
class Car @Inject constructor(
    private var driver: Driver,
    private var engine: Engine,
    private var wheels: Wheels
) {

    @Inject
    fun enableRemote(remote: Remote) {
        remote.setListener(this)
    }

    fun drive() {
        engine.start()
        Log.e("Car", "$driver drives $this")
    }
}