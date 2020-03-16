package com.github.yasukotelin.ui_user_detail

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yasukotelin.model.User
import com.github.yasukotelin.ui_core.result.Event
import com.github.yasukotelin.usecase_palette.PaletteUseCase
import com.github.yasukotelin.usecase_palette.PaletteUseCaseImpl
import com.github.yasukotelin.usecase_user.UserUseCase
import com.github.yasukotelin.usecase_user.UserUseCaseImpl
import kotlinx.coroutines.launch

class UserDetailViewModel : ViewModel() {

    private val userUseCase: UserUseCase by lazy { UserUseCaseImpl() }

    private val paletteUseCase: PaletteUseCase by lazy {
        PaletteUseCaseImpl()
    }

    private val _user: MutableLiveData<User> = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    private val _navigateBackAction: MutableLiveData<Event<Unit>> = MutableLiveData<Event<Unit>>()
    val navigateBackAction: LiveData<Event<Unit>>
        get() = _navigateBackAction

    private val _statusBarColor: MutableLiveData<Int> =
        MutableLiveData<Int>()
    val statusBarColor: LiveData<Int>
        get() = _statusBarColor

    fun fetchUser(id: Int) {
        userUseCase.getUser(id)?.run {
            _user.postValue(this)
        }
    }

    fun fetchStatusBarColor(bitmap: Bitmap) = viewModelScope.launch {
        _statusBarColor.postValue(paletteUseCase.getMutedColor(bitmap))
    }

    fun onPressedBackAllow() {
        _navigateBackAction.postValue(Event(Unit))
    }
}
