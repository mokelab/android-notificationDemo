package com.mokelab.demo.notification

import android.app.NotificationChannel
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mokelab.demo.notification.databinding.ChannelItemBinding

/**
 * ChannelAdapter
 */
class ChannelAdapter(context : Context) : RecyclerView.Adapter<ChannelAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private val items = ArrayList<NotificationChannel>()

    fun set(items : List<NotificationChannel>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(ChannelItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.channel = items[position]
        holder.binding.executePendingBindings()
    }


    class ViewHolder(val binding : ChannelItemBinding) : RecyclerView.ViewHolder(binding.root)
}