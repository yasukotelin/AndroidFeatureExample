package com.github.yasukotelin.ui_user_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.yasukotelin.model.User
import com.github.yasukotelin.ui_core.result.Event
import com.github.yasukotelin.usecase_user.UserUseCase
import com.github.yasukotelin.usecase_user.UserUseCaseImpl

class UserDetailViewModel : ViewModel() {

    private val userUseCase: UserUseCase by lazy { UserUseCaseImpl() }

    private val _user: MutableLiveData<User> = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    private val _navigateBackAction: MutableLiveData<Event<Unit>> = MutableLiveData<Event<Unit>>()
    val navigateBackAction: LiveData<Event<Unit>>
        get() = _navigateBackAction

    fun fetchUser(id: Int) {
        userUseCase.getUser(id)?.run {
            _user.postValue(this)
        }
    }

    fun onPressedBackAllow() {
        _navigateBackAction.postValue(Event(Unit))
    }
}
