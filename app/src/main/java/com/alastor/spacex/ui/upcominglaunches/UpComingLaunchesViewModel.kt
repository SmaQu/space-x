package com.alastor.spacex.ui.upcominglaunches

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alastor.spacex.extensions.runSingle
import com.alastor.spacex.model.UpcomingLaunch
import com.alastor.spacex.repository.Repository
import com.alastor.spacex.repository.Resource
import io.reactivex.disposables.CompositeDisposable

class UpComingLaunchesViewModel @ViewModelInject constructor(
    private val repository: Repository,
    private val disposable: CompositeDisposable
) : ViewModel() {

    private val upComingLaunchesLiveData = MutableLiveData<Resource<List<UpcomingLaunch>>>()
    fun upComingLaunches(): LiveData<Resource<List<UpcomingLaunch>>> {
        return upComingLaunchesLiveData.runSingle(repository.getUpComingLaunches()) { d ->
            disposable.add(d)
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
