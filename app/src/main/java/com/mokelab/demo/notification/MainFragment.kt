package com.mokelab.demo.notification

import android.os.Bundle
import android.support.v4.app.ListFragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

/**
 * MainFragment
 */
class MainFragment : ListFragment() {

    companion object Factory {
        fun newInstance() = MainFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val labels = resources.getStringArray(R.array.main_menu)
        this.listAdapter = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, labels)
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        FragmentUtils.toNextFragment(fragmentManager, R.id.container, when(position) {
            0 -> ChannelFragment.newInstance()
            1 -> ShowNotificationFragment.newInstance()
            else -> ChannelFragment.newInstance()
        }, true)
    }
}