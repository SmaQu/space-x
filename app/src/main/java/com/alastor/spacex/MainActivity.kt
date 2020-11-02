package com.alastor.spacex

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alastor.spacex.model.Capsule
import com.alastor.spacex.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, providerFactory).get(MainViewModel::class.java)
    }

    private fun inject() {
        (application as MainApplication).appComponent
            .mainComponent()
            .create()
            .inject(this)
    }
}