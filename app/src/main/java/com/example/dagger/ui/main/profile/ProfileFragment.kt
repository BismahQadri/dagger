package com.example.dagger.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dagger.R
import com.example.dagger.SessionManager
import com.example.dagger.models.User
import com.example.dagger.ui.auth.AuthResource
import com.example.dagger.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

class ProfileFragment : DaggerFragment() {
    private lateinit var viewModel: ProfileViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Toast.makeText(context, "Profile Fragment", Toast.LENGTH_SHORT).show()
        viewModel = ViewModelProvider(this, providerFactory).get(ProfileViewModel::class.java)
        setUserDetails(sessionManager.cachedUser.value?.data)
        //subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.authUser.removeObservers(viewLifecycleOwner)
        viewModel.authUser.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
            when (it.status) {
                AuthResource.AuthStatus.AUTHENTICATED -> {
                    setUserDetails(it.data)
                }
                AuthResource.AuthStatus.ERROR -> {
                    setErrorDetails(it.message)
                }
                else -> {
                    return@Observer
                }
            }
        })
    }

    private fun setErrorDetails(message: String?) {
        email.text = message
        username.text = "error"
        website.text = "error"
    }

    private fun setUserDetails(data: User?) {
        email.text = data?.email
        username.text = data?.username
        website.text = data?.website
    }
}