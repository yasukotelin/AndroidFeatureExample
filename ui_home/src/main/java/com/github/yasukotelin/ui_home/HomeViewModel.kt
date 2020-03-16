package com.github.yasukotelin.ui_home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.yasukotelin.model.User
import com.github.yasukotelin.ui_core.result.Event
import com.github.yasukotelin.usecase_user.UserUseCase
import com.github.yasukotelin.usecase_user.UserUseCaseImpl

class HomeViewModel : ViewModel(), HomeControllerDelegation {

    private val userUseCase: UserUseCase by lazy { UserUseCaseImpl() }

    private val _users: MutableLiveData<List<User>> = MutableLiveData<List<User>>().apply {
        this.postValue(
            userUseCase.getUsers()
        )
    }
    val user: LiveData<List<User>>
        get() = _users

    private val _navigateToUserDetailAction: MutableLiveData<Event<Int>> = MutableLiveData<Event<Int>>()
    val navigateToUserDetailAction: LiveData<Event<Int>>
        get() = _navigateToUserDetailAction

    override fun onClickUserCard(id: Int) {
        _navigateToUserDetailAction.postValue(Event(id))
    }
}
