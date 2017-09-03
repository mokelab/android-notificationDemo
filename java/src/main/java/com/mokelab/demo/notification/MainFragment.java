package com.mokelab.demo.notification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * MainFragment
 */

public class MainFragment extends ListFragment {
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] labels = getResources().getStringArray(R.array.main_menu);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, labels);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
        case 0:
            FragmentUtils.toNextFragment(getFragmentManager(), R.id.container,
                    ChannelFragment.newInstance(), true);
            break;
        case 1:
            FragmentUtils.toNextFragment(getFragmentManager(), R.id.container,
                    ShowNotificationFragment.newInstance(), true);
            break;
        }
    }
}
