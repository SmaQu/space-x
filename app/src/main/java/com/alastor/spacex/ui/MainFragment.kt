package com.alastor.spacex.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.alastor.spacex.MainActivity
import com.alastor.spacex.R
import com.alastor.spacex.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.text_hello_there).text = "Fragment Hello there"
        Log.w(TAG, "onViewCreated: $providerFactory")
    }

    private fun inject() {
        (activity as MainActivity).mainComponent().inject(this)
    }

    companion object {
        private const val TAG = "MainFragment"
    }
}