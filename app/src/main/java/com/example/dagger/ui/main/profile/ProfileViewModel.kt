package com.example.dagger.ui.main.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ProfileViewModel @Inject constructor(): ViewModel() {
    init {
        Log.e("Profile View "," Model ready")
    }
}