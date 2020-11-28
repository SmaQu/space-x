package com.alastor.spacex.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alastor.spacex.repository.Resource
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

fun <T : Any> MutableLiveData<Resource<T>>.single(
    single: Single<T>,
    function: (Disposable) -> Unit
): LiveData<Resource<T>> {
    if (this.value != Resource.Loading) {
        single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<T> {
                override fun onSubscribe(d: Disposable) {
                    this@single.value = Resource.Loading
                    function.invoke(d)
                }

                override fun onSuccess(it: T) {
                    this@single.value = Resource.Success(it)
                }

                override fun onError(e: Throwable) {
                    this@single.value = Resource.Error(e)
                }
            })
    }

    return this
}