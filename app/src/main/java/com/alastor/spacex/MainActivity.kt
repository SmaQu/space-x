package com.alastor.spacex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alastor.spacex.di.main.MainComponent
import com.alastor.spacex.ui.MainFragment
import com.alastor.spacex.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    private lateinit var viewModel: MainViewModel

    private var mainComponent: MainComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, providerFactory).get(MainViewModel::class.java)

        supportFragmentManager.beginTransaction().add(R.id.container, MainFragment()).commit()

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
}