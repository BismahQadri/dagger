package com.example.dagger.ui.auth

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.dagger.R
import com.example.dagger.ui.auth.AuthResource.*
import com.example.dagger.ui.main.MainActivity
import com.example.dagger.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    private lateinit var viewModel: AuthViewModel

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)
        setLogo()
        subscribeObservers()
        login_button.setOnClickListener {
            attemptLogin()
        }
    }

    private fun attemptLogin() {
        if (TextUtils.isEmpty(user_id_input.text.toString())) return
        viewModel.authenticateWithId(user_id_input.text.toString().toInt())
    }

    private fun setLogo() {
        requestManager
            .load(logo)
            .into(login_logo)
    }

    private fun onLoginSuccess() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun subscribeObservers() {
        viewModel.authUser.observe(this, Observer {
            if (it != null) {
                when (it.status) {
                    AuthStatus.LOADING -> {
                        progress_bar.visibility = View.VISIBLE
                    }
                    AuthStatus.AUTHENTICATED -> {
                        progress_bar.visibility = View.GONE
                        onLoginSuccess()
                    }
                    AuthStatus.ERROR -> {
                        progress_bar.visibility = View.GONE
                        Toast.makeText(
                            this,
                            "${it.message} \nDid you enter number between 1 and 10?",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                    AuthStatus.NOT_AUTHENTICATED -> {
                        progress_bar.visibility = View.GONE
                        Log.e("on Error", "Not AUthenticated")

                    }
                }
            }
        })
    }
}
