package com.alastor.spacex.ui.upcominglaunches

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alastor.spacex.*
import com.alastor.spacex.repository.Resource
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable
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

        requestUpComingLaunches()
        observeUpComingLaunches()
    }

    private fun requestUpComingLaunches() {
        viewModel.requestUpComingLaunches()
    }

    private fun observeUpComingLaunches() {
        viewModel.upComingLaunchesLiveData.observe(viewLifecycleOwner, Observer {

            when (it) {
                Resource.Loading -> Log.d("TAG", "Loading...")
                is Resource.Success -> {
                    upcomingLaunchesAdapter.list = it.data
                    it.data.forEach {
                        Log.d("TAG", "Success...: ${it.name}")
                    }
                }
                is Resource.Error -> Log.d("TAG", "Error...")
            }
        })
    }

    private fun initRecycler() {
        recycler_view_upcoming_launches.apply {
            setHasFixedSize(true)
            adapter = upcomingLaunchesAdapter
        }
    }
}