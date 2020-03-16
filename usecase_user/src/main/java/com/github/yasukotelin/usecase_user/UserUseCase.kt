package com.github.yasukotelin.usecase_user

import com.github.yasukotelin.model.User
import com.github.yasukotelin.repository_user.UserRepository
import com.github.yasukotelin.repository_user.UserRepositoryImpl

interface UserUseCase {
    fun getUsers(): List<User>
    fun getUser(id: Int): User?
}

class UserUseCaseImpl : UserUseCase {

    private val repository: UserRepository by lazy {
        UserRepositoryImpl()
    }

    override fun getUsers(): List<User> {
        return repository.getUsers()
    }

    override fun getUser(id: Int): User? {
        return repository.getUser(id)
    }
}