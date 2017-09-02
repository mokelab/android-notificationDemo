package com.mokelab.demo.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mokelab.demo.notification.databinding.CreateChannelFragmentBinding

/**
 * CreateChannelFragment shows form for channel creation
 */
class CreateChannelFragment : Fragment() {

    private lateinit var binding : CreateChannelFragmentBinding

    companion object Factory {
        fun newInstance() = CreateChannelFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.binding = CreateChannelFragmentBinding.inflate(inflater!!, container, false)

        this.binding.button.setOnClickListener {
            submit()
        }

        return this.binding.root
    }

    private fun submit() {
        val id = this.binding.id
        val name = this.binding.name
        val description = this.binding.description ?: ""

        val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT)
        channel.description = description

        val manager = context.getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)

        fragmentManager?.popBackStackImmediate()
    }

}