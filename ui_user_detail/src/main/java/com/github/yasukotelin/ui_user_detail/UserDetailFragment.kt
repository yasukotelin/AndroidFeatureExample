package com.github.yasukotelin.ui_user_detail

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
            this.user.observe(viewLifecycleOwner, Observer {
                this.fetchStatusBarColor(BitmapFactory.decodeResource(resources, it.headerResId))
            })
            this.statusBarColor.observe(viewLifecycleOwner, Observer { color ->
                activity?.also {
                    it.window.statusBarColor = color
                }
            })
        }
    }

    override fun onStart() {
        super.onStart()

        userId?.also {
            userDetailViewModel.fetchUser(it)
        }
    }

    override fun onStop() {
        super.onStop()

        activity?.also {
            // シングルActivityなので移動する時には元のカラーに戻す必要がある
            it.window.statusBarColor =
                resources.getColor(R.color.colorDefaultStatusBar, it.theme)
        }
    }
}
