package com.mokelab.demo.notification

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Utility class
 */
class FragmentUtils {
    companion object {
        fun toNextFragment(manager : FragmentManager?, @IdRes containerId : Int,
                           next : Fragment, addToBackStack : Boolean) {
            val transaction = manager?.beginTransaction()

            if (addToBackStack) {
                transaction?.addToBackStack(null)
            }
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            transaction?.replace(containerId, next)

            transaction?.commit()
        }
    }
}