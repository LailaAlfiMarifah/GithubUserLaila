package com.example.githubuserlaila.model

data class DetailUserResponse(
    val login: String,
    val name: String,
    val bio: String,
    val avatar_url: String,
    val followers_url: String,
    val following_url: String,
    val followers: Int,
    val following: Int
)
