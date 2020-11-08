package com.alastor.spacex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alastor.spacex.di.main.MainComponent

class MainActivity : AppCompatActivity() {

    private var mainComponent: MainComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun mainComponent(): MainComponent {
        if (mainComponent == null) {
            mainComponent = (application as MainApplication).appComponent
                .mainComponent()
                .create()
        }
        return mainComponent as MainComponent
    }

    private fun inject() {
        mainComponent().inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainComponent = null;
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}