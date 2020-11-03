package com.alastor.spacex

import android.util.Log
import androidx.lifecycle.ViewModel
import com.alastor.spacex.model.Capsule
import com.alastor.spacex.repository.CapsuleRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(capsuleRepository: CapsuleRepository) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    init {
        Log.d("TAG", "Initialization of MainViewModel: ")

        capsuleRepository.getAllCapsules()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Capsule>> {
                override fun onSubscribe(d: Disposable) {
                    disposable.add(d)
                    Log.d(TAG, "onSubscribe: ")
                }

                override fun onSuccess(capsuleList: List<Capsule>) {
                    capsuleList.forEach {
                        Log.d(TAG, "onSuccess: ${it.id}")
                    }
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "onError: $e")
                }

            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    companion object {
        private const val TAG = "MainViewModel"
    }

}