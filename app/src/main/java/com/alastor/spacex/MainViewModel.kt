package com.alastor.spacex

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alastor.spacex.model.Capsule
import com.alastor.spacex.repository.CapsuleRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val capsuleRepository: CapsuleRepository) :
    ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    private val _capsuleLiveData = MutableLiveData<List<Capsule>>()
    val capsuleLiveData: LiveData<List<Capsule>> by this::_capsuleLiveData

    public fun makeRequest(): LiveData<List<Capsule>> {
        return LiveDataReactiveStreams.fromPublisher(
            capsuleRepository.getAllCapsules()
                .subscribeOn(Schedulers.io())
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}