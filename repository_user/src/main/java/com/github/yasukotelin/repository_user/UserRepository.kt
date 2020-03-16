package com.github.yasukotelin.repository_user

import com.github.yasukotelin.model.User

interface UserRepository {
    fun getUsers(): List<User>
    fun getUser(id: Int): User?
}

class UserRepositoryImpl : UserRepository {

    private val users: List<User> = listOf(
        User(
            id = 1,
            name = "Suzuki Taro",
            job = "Employee",
            age = 32,
            email = "suzuki-ichiban@example.com",
            avatarResId = R.drawable.taro_icon,
            headerResId = R.drawable.taro_header
        ),
        User(
            id = 2,
            name = "Aggy Jeffery",
            job = "Android developer",
            age = 25,
            email = "agigi@example.com",
            avatarResId = R.drawable.aggy_icon,
            headerResId = R.drawable.aggy_header
        ),
        User(
            id = 3,
            name = "Xan Temple",
            job = "Pianist",
            age = 41,
            email = "pipipi@example.com",
            avatarResId = R.drawable.xan_icon,
            headerResId = R.drawable.xan_header
        ),
        User(
            id = 4,
            name = "George White",
            job = "Carpenter",
            age = 22,
            email = "wood@example.com",
            avatarResId = R.drawable.george_icon,
            headerResId = R.drawable.geroge_header
        )
    )

    override fun getUsers(): List<User> {
        return users
    }

    override fun getUser(id: Int): User? {
        return users.find { it.id == id }
    }

}