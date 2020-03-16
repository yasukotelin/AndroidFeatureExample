package com.github.yasukotelin.model

data class User(
    val id: Int,
    val name: String,
    val job: String,
    val age: Int,
    val email: String,
    val avatarResId: Int,
    val headerResId: Int
)