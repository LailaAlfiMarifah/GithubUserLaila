package com.example.githubuserlaila.retrofit

import com.example.githubuserlaila.model.DetailUserResponse
import com.example.githubuserlaila.model.User
import com.example.githubuserlaila.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}