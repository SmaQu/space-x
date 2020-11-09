package com.alastor.spacex.ui.upcominglaunches

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alastor.spacex.MainActivity
import com.alastor.spacex.R
import com.alastor.spacex.repository.Resource
import com.alastor.spacex.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class UpComingLaunchesFragment : Fragment(R.layout.fragment_upcoming_launches) {

    @Inject
    lateinit var factoryProvider: ViewModelProviderFactory

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

        viewModel.requestUpComingLaunches()
        viewModel.upComingLaunchesLiveData.observe(viewLifecycleOwner, Observer {

            when (it) {
                Resource.Loading -> Log.d("TAG", "Loading...")
                is Resource.Success -> {
                    it.data.forEach {
                        Log.d("TAG", "Success...: ${it.datePrecision}")
                    }
                }
                is Resource.Error -> Log.d("TAG", "Error...")
            }
        })
    }

    private fun inject() {
        (activity as MainActivity).mainComponent().inject(this)
    }
}