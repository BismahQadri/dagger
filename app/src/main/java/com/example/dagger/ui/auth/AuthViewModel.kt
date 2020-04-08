package com.example.dagger.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.dagger.SessionManager
import com.example.dagger.models.User
import com.example.dagger.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(private var authApi: AuthApi, private var sessionManager: SessionManager) : ViewModel() {

     val authUser: LiveData<AuthResource<User>>
    get() = sessionManager.cachedUser

    fun authenticateWithId(userId: Int) {
       sessionManager.authenticateWIthId(queryUserId(userId) as LiveData<AuthResource<User>>)

    }

    private fun queryUserId(userId: Int) : LiveData<AuthResource<out User?>> {
        return LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userId)
                .onErrorReturn {
                    return@onErrorReturn User(-1, "hhh","jsjj","hsdh")
                }
                .map {
                    if (it.id == -1){
                        return@map AuthResource.error("Could not Authenticate", null)
                    }
                    return@map AuthResource.authenticated(it)
                }
                .subscribeOn(Schedulers.io())
        )
    }



}