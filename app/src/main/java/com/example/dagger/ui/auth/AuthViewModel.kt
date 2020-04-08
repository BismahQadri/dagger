package com.example.dagger.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.dagger.models.User
import com.example.dagger.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(private var authApi: AuthApi) : ViewModel() {

    private val _authUser = MediatorLiveData<AuthResource<User>>()
     val authUser: LiveData<AuthResource<User>>
    get() = _authUser

    fun authenticateWithId(userId: Int) {
        _authUser.value = AuthResource.loading(null)
        val source = LiveDataReactiveStreams.fromPublisher(
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
        _authUser.addSource(source) {
            _authUser.value = it as AuthResource<User>
            _authUser.removeSource(source)

        }

    }



}