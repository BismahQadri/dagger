package com.example.dagger.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dagger.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(authApi: AuthApi) : ViewModel() {

    init {
     authApi.getUser(1)
         .toObservable()
         .subscribeOn(Schedulers.io())
         .subscribe({
            Log.e("on Next:", it.email)
         },{
            Log.e("on Error:", "is $it")
         },{

         }, {

         })
    }
}