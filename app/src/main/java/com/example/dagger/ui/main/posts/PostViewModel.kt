package com.example.dagger.ui.main.posts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dagger.SessionManager
import com.example.dagger.models.User
import com.example.dagger.network.main.MainApi
import com.example.dagger.ui.auth.AuthResource
import javax.inject.Inject

class PostViewModel @Inject constructor(private val sessionManager: SessionManager, private  val mainApi: MainApi): ViewModel() {
    init {
        Log.e("Posts View "," Model ready")
    }

    val authUser: LiveData<AuthResource<User>>
        get() = sessionManager.cachedUser
}