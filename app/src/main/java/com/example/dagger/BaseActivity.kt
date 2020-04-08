package com.example.dagger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.dagger.ui.auth.AuthActivity
import com.example.dagger.ui.auth.AuthResource
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeObservers()
    }

    private fun subscribeObservers() {

        sessionManager.cachedUser.observe(this, Observer {
            if (it != null) {
                when (it.status) {
                    AuthResource.AuthStatus.LOADING -> {

                    }
                    AuthResource.AuthStatus.AUTHENTICATED -> {
                        Log.e("on Authenticated", it.data?.email)
                    }
                    AuthResource.AuthStatus.ERROR -> {
                        Log.e("on Error", "is"+it.message)
                    }
                    AuthResource.AuthStatus.NOT_AUTHENTICATED -> {
                        navLoginScreen()
                    }
                }
            }
        })
    }

    private fun navLoginScreen() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

}