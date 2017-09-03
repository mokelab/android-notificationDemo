package com.mokelab.demo.notification;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Utility class
 */
public class FragmentUtils {
    public static void toNextFragment(FragmentManager manager, @IdRes int containerId,
                                      Fragment next, boolean addToBackStack) {
        if (manager == null) { return; }
        FragmentTransaction transaction = manager.beginTransaction();

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(containerId, next);

        transaction.commit();
    }
}
