package com.alastor.spacex.extensions

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alastor.spacex.repository.Resource
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun <T : Any> MutableLiveData<Resource<T>>.runSingle(
    single: Single<T>,
    function: (Disposable) -> Unit
): LiveData<Resource<T>> {

    when (this.value) {

        is Resource.Loading -> {
            this.value = Resource.Loading((this.value as Resource.Loading).data)
        }

        else -> {

            single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<T> {

                    override fun onSubscribe(d: Disposable) {

                        when (this@runSingle.value) {

                            is Resource.Success -> {
                                this@runSingle.value =
                                    Resource.Loading((this@runSingle.value as Resource.Success).data)
                            }

                            is Resource.Error -> {
                                this@runSingle.value = Resource.Loading(null)
                            }

                            null -> {
                                this@runSingle.value = Resource.Loading(null)
                            }
                        }

                        function.invoke(d)
                    }

                    override fun onSuccess(it: T) {
                        this@runSingle.value = Resource.Success(it)
                    }

                    override fun onError(e: Throwable) {
                        this@runSingle.value = Resource.Error(e)
                    }
                })
        }
    }

    return this
}