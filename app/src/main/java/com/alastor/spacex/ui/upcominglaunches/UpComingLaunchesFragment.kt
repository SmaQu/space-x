package com.alastor.spacex.ui.upcominglaunches

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alastor.spacex.R
import com.alastor.spacex.repository.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_upcoming_launches.*
import javax.inject.Inject

@AndroidEntryPoint
class UpComingLaunchesFragment : Fragment(R.layout.fragment_upcoming_launches) {

    @Inject
    lateinit var upcomingLaunchesAdapter: UpcomingLaunchesAdapter

    private val viewModel: UpComingLaunchesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()

        getUpComingLaunches()
        setUpSwipeRefresh();
    }

    private fun setUpSwipeRefresh() {
        swipe_refresh_upcoming_launches.setOnRefreshListener {
            getUpComingLaunches()
        }
    }

    private fun getUpComingLaunches() {
        viewModel.upComingLaunches().observe(viewLifecycleOwner) {

            when (it) {

                is Resource.Loading -> {

                    if (it.data == null || it.data.isEmpty()) {
                        loadingView()
                    } else {
                        upcomingLaunchesAdapter.list = it.data
                        showRecycler(true)
                        showProgress(false)
                    }
                }

                is Resource.Success -> {

                    if (it.data == null || it.data.isEmpty()) {
                        Log.d("TAG", "Empty List...: ")
                    } else {
                        upcomingLaunchesAdapter.list = it.data
                        successView()
                    }
                }

                is Resource.Error -> {
                    Log.e("TAG", "Error")
                }
            }
        }
    }

    private fun loadingView() {
        showRecycler(false)
        showProgress(true)
    }

    private fun successView() {
        showRecycler(true)
        showProgress(false)
        showSwipeRefreshView(false)
    }

    private fun showSwipeRefreshView(isVisible: Boolean) {
        swipe_refresh_upcoming_launches.isRefreshing = isVisible
    }

    private fun showRecycler(isVisible: Boolean) {
        recycler_view_upcoming_launches.isVisible = isVisible
    }

    private fun showProgress(isVisible: Boolean) {
        progress_upcoming_launches.isVisible = isVisible
    }

    private fun initRecycler() {
        recycler_view_upcoming_launches.apply {
            setHasFixedSize(true)
            adapter = upcomingLaunchesAdapter
        }
    }
}