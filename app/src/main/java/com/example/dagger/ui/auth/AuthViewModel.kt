package com.example.dagger.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dagger.network.auth.AuthApi
import javax.inject.Inject

class AuthViewModel @Inject constructor(authApi: AuthApi?) : ViewModel() {

    init {
        if (authApi == null) {
            Log.e("Auth Api","is null")
        } else Log.e("Auth Api","is not null")
    }
}