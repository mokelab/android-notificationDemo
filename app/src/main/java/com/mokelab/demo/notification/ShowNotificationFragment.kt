package com.mokelab.demo.notification

import android.app.NotificationManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.NotificationCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mokelab.demo.notification.databinding.ShowNotificationFragmentBinding

/**
 * ShowNotificationFragment
 */
class ShowNotificationFragment : Fragment() {

    private lateinit var binding : ShowNotificationFragmentBinding

    companion object {
        fun newInstance() = ShowNotificationFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.binding = ShowNotificationFragmentBinding.inflate(inflater!!, container, false)

        this.binding.submitButton.setOnClickListener {
            submit()
        }

        return this.binding.root
    }

    private fun submit() {
        val id = this.binding.id ?: ""
        val title = this.binding.title ?: ""

        val manager = context.getSystemService(NotificationManager::class.java)

        val builder = NotificationCompat.Builder(context, id).apply {
            setContentText(title)
            setSmallIcon(R.drawable.ic_add_24dp)
        }

        manager.notify(1, builder.build())
    }
}