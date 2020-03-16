package com.github.yasukotelin.ui_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.github.yasukotelin.ui_core.result.EventObserver
import com.github.yasukotelin.ui_home.databinding.HomeFragmentBinding


class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    private val homeController: HomeController by lazy {
        HomeController(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = HomeFragmentBinding.inflate(inflater, container, false).apply {
            this.lifecycleOwner = viewLifecycleOwner
            recyclerView.setController(homeController)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.run {
            this.user.observe(viewLifecycleOwner, Observer {
                homeController.setData(it)
            })
            this.navigateToUserDetailAction.observe(viewLifecycleOwner, EventObserver {
                findNavController().navigate(HomeFragmentDirections.toUserDetailFragment(userId = it))
            })
        }
    }

}
