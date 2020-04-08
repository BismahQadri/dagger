package com.example.dagger

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.dagger.models.User
import com.example.dagger.ui.auth.AuthResource
import javax.inject.Inject

class SessionManager @Inject constructor() {
    private val _cachedUser = MediatorLiveData<AuthResource<User>>()
    val cachedUser: LiveData<AuthResource<User>>
    get() = _cachedUser

    fun authenticateWIthId(source: LiveData<AuthResource<User>>) {
       _cachedUser.value = AuthResource.loading(null)
        _cachedUser.addSource(source){
            _cachedUser.value = it
            _cachedUser.removeSource(source)
        }
    }

    fun logout() {
        Log.e("Logout", "Logging Out..")
        _cachedUser.value = AuthResource.logout()
    }


}