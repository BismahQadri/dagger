package com.example.dagger.ui.main.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dagger.R
import com.example.dagger.ui.auth.AuthResource
import com.example.dagger.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostsFragment : DaggerFragment() {
    private lateinit var viewModel: PostViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Toast.makeText(context, "Profile Fragment", Toast.LENGTH_SHORT).show()
        viewModel = ViewModelProvider(this, providerFactory).get(PostViewModel::class.java)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.authUser.removeObservers(viewLifecycleOwner)
        viewModel.authUser.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
            when (it.status) {
                AuthResource.AuthStatus.AUTHENTICATED -> {

                }
                AuthResource.AuthStatus.ERROR -> {

                }
                else -> {
                    return@Observer
                }
            }
        })
    }
}