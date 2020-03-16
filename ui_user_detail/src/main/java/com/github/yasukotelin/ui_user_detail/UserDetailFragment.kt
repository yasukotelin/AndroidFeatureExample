package com.github.yasukotelin.ui_user_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.github.yasukotelin.ui_core.result.EventObserver
import com.github.yasukotelin.ui_user_detail.databinding.UserDetailFragmentBinding


class UserDetailFragment : Fragment() {

    private val userId: Int?
        get() = arguments?.let { UserDetailFragmentArgs.fromBundle(it).userId }

    private val userDetailViewModel: UserDetailViewModel by lazy {
        ViewModelProviders.of(this).get(UserDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = UserDetailFragmentBinding.inflate(
            inflater, container, false
        ).apply {
            viewModel = userDetailViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userDetailViewModel.apply {
            this.navigateBackAction.observe(viewLifecycleOwner, EventObserver {
                findNavController().popBackStack()
            })
        }
    }

    override fun onStart() {
        super.onStart()

        userId?.also {
            userDetailViewModel.fetchUser(it)
        }
    }

}
