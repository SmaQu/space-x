package com.alastor.spacex.ui.upcominglaunches

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.alastor.spacex.R
import com.alastor.spacex.model.UpcomingLaunch
import com.bumptech.glide.RequestManager
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.android.synthetic.main.item_upcominglaunch.view.*
import org.joda.time.DateTime
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@FragmentScoped
class UpcomingLaunchesAdapter @Inject constructor(
    private val requestManager: RequestManager,
    private val simpleDateFormat: SimpleDateFormat
) :
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

        fun bindViews(upcomingLaunch: UpcomingLaunch) {
            testStrings(upcomingLaunch)
            itemView.text_view_name.text = upcomingLaunch.name
            itemView.text_view_date.text = getTime(upcomingLaunch.dateUTC)

            upcomingLaunch.staticFireDateUTC?.let {
                itemView.text_view_static_fire.text = getTime(upcomingLaunch.staticFireDateUTC)
                showStaticFireDate(true)
            } ?: run {
                showStaticFireDate(false)
            }

            itemView.text_view_flight_number.text = upcomingLaunch.flightNumber.toString()
            itemView.text_view_cores_flight.text = upcomingLaunch.cores.first().flight.toString()
            itemView.text_view_cores_description.text = upcomingLaunch.details

            requestManager
                .load(upcomingLaunch.links.patch.small)
                .into(itemView.image_view_photo)
        }

        private fun showStaticFireDate(visible: Boolean) {
            itemView.text_view_static_fire.isVisible = visible
            itemView.text_view_static_date_label.isVisible = visible
            itemView.image_view_static_date.isVisible = visible
        }

        private fun getTime(iso8601Date: String): String {
            val date = DateTime(iso8601Date).toDate()
            return simpleDateFormat.format(date)
        }

        private fun testStrings(upcomingLaunch: UpcomingLaunch) {
            val values = upcomingLaunch.toString().split(",")

            val strings = StringBuilder()

            values.forEach {
                strings.appendLine(it)
            }
            Log.d("TAG", "bindViews: $strings")
        }
    }

}