package com.mokelab.demo.notification

import android.app.NotificationManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mokelab.demo.notification.databinding.ChannelFragmentBinding

/**
 * ChannelFragment shows channel list
 */
class ChannelFragment : Fragment() {

    private lateinit var binding : ChannelFragmentBinding
    private var adapter : ChannelAdapter? = null

    companion object {
        fun newInstance() = ChannelFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.binding = ChannelFragmentBinding.inflate(inflater!!, container, false)

        this.binding.recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        this.binding.fab.setOnClickListener {
            FragmentUtils.toNextFragment(fragmentManager, R.id.container,
                    CreateChannelFragment.newInstance(), true)
        }

        return this.binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (adapter == null) {
            fetchChannels()
        } else {
            this.binding.recycler.adapter = adapter
            fetchChannels()
        }
    }

    private fun fetchChannels() {
        val manager = context.getSystemService(NotificationManager::class.java)
        val channels = manager.notificationChannels

        if (this.adapter == null) {
            this.adapter = ChannelAdapter(context)
            this.adapter!!.set(channels)
            this.binding.recycler.adapter = this.adapter!!
        } else {
            this.adapter!!.set(channels)
            this.adapter!!.notifyDataSetChanged()
        }
    }

}