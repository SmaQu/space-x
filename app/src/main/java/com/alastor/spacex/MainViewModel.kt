package com.alastor.spacex

import android.util.Log
import androidx.lifecycle.ViewModel
import com.alastor.spacex.model.Capsule
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {

    init {
        Log.d("TAG", "Initialization of MainViewModel: ")
    }

}