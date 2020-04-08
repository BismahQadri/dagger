package com.example.dagger.network.main

import com.example.dagger.models.Posts
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {

    @GET("posts")
    fun getPostsFromUser(
        @Query("userId") id: Int
    ) : Flowable<List<Posts>>
}