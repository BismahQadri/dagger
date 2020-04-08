package com.example.dagger.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dagger.R
import dagger.android.support.DaggerFragment

class ProfileFragment : DaggerFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(context, "Profile Fragment", Toast.LENGTH_SHORT).show()
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}