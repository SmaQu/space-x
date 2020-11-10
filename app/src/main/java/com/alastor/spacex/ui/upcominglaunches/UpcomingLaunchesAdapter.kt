package com.alastor.spacex.ui.upcominglaunches

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alastor.spacex.R
import com.alastor.spacex.model.UpcomingLaunch
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class UpcomingLaunchesAdapter @Inject constructor() :
    RecyclerView.Adapter<UpcomingLaunchesAdapter.UpcomingLaunchViewHolder>() {

    var list: List<UpcomingLaunch> = Collections.emptyList()
        set(value) {
            field = ArrayList<UpcomingLaunch>(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingLaunchViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_upcominglaunch, parent, false)
        return UpcomingLaunchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UpcomingLaunchViewHolder, position: Int) {
        val upcomingLaunch = list[position]
        holder.bindViews(upcomingLaunch)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class UpcomingLaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var itemTextView: TextView = itemView.findViewById(R.id.text_view_test_item)

        fun bindViews(upcomingLaunch: UpcomingLaunch) {
            itemTextView.text = upcomingLaunch.toString()
        }
    }

}