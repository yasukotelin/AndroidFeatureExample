package com.github.yasukotelin.ui_home

import com.airbnb.epoxy.TypedEpoxyController
import com.github.yasukotelin.model.User
import com.github.yasukotelin.ui_core.userCard

class HomeController(
    private val delegation: HomeControllerDelegation
) : TypedEpoxyController<List<User>>() {
    override fun buildModels(users: List<User>) {
        users.forEach {
            userCard {
                this.id(modelCountBuiltSoFar)
                this.user(it)
                this.onClick { _ ->
                    delegation.onClickUserCard(it.id)
                }
            }
        }
    }
}

interface HomeControllerDelegation {
    fun onClickUserCard(id: Int)
}