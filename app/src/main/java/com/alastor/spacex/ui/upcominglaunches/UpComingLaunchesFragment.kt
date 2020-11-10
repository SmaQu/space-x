package com.alastor.spacex.ui.upcominglaunches

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alastor.spacex.*
import com.alastor.spacex.model.pagination.Options
import com.alastor.spacex.model.pagination.Query
import com.alastor.spacex.model.pagination.QueryBody
import com.alastor.spacex.repository.Resource
import com.alastor.spacex.viewmodel.ViewModelProviderFactory
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_upcoming_launches.*
import javax.inject.Inject

class UpComingLaunchesFragment : Fragment(R.layout.fragment_upcoming_launches) {

    @Inject
    lateinit var factoryProvider: ViewModelProviderFactory

    @Inject
    lateinit var upcomingLaunchesAdapter: UpcomingLaunchesAdapter

    private lateinit var viewModel: UpComingLaunchesViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, factoryProvider).get(UpComingLaunchesViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()

        requestUpComingLaunches()
        observeUpComingLaunches()

    }

    private fun inject() {
        (activity as MainActivity).mainComponent().inject(this)
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