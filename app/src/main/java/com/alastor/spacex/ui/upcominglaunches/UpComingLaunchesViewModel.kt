package com.alastor.spacex.ui.upcominglaunches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alastor.spacex.model.UpcomingLaunch
import com.alastor.spacex.repository.Repository
import com.alastor.spacex.repository.Resource
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UpComingLaunchesViewModel
@Inject constructor(
    private val repository: Repository,
    private val disposable: CompositeDisposable
) : ViewModel() {

    private val _upComingLaunchesLiveData = MutableLiveData<Resource<List<UpcomingLaunch>>>()
    val upComingLaunchesLiveData: LiveData<Resource<List<UpcomingLaunch>>>
        get() = _upComingLaunchesLiveData

    public fun requestUpComingLaunches() {
        repository.getUpComingLaunches()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<UpcomingLaunch>> {
                override fun onSubscribe(d: Disposable) {
                    _upComingLaunchesLiveData.value = Resource.Loading
                    disposable.add(d)
                }

                override fun onSuccess(it: List<UpcomingLaunch>) {
                    _upComingLaunchesLiveData.value = Resource.Success(it)
                }

                override fun onError(e: Throwable) {
                    _upComingLaunchesLiveData.value = Resource.Error(e)
                }
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}