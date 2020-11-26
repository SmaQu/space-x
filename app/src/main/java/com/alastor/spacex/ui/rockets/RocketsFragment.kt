package com.alastor.spacex.ui.rockets

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alastor.spacex.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketsFragment : Fragment(R.layout.fragment_rockets) {

    private val viewModel: RocketsViewModel by viewModels()
}