package com.example.dagger.ui.main.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dagger.SessionManager
import com.example.dagger.models.User
import com.example.dagger.ui.auth.AuthResource
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private val sessionManager: SessionManager): ViewModel() {
    init {
        Log.e("Profile View "," Model ready")
    }

    val authUser: LiveData<AuthResource<User>>
        get() = sessionManager.cachedUser
}