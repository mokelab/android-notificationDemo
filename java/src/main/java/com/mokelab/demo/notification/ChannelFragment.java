package com.mokelab.demo.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mokelab.demo.notification.databinding.ChannelFragmentBinding;

import java.util.List;

/**
 * ChannelFragment
 */

public class ChannelFragment extends Fragment {

    private ChannelFragmentBinding binding;
    private ChannelAdapter adapter;

    public static ChannelFragment newInstance() {
        return new ChannelFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = ChannelFragmentBinding.inflate(inflater, container, false);

        this.binding.recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        this.binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentUtils.toNextFragment(getFragmentManager(), R.id.container,
                        CreateChannelFragment.newInstance(), true);
            }
        });

        return this.binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (adapter == null) {
            fetchChannels();
        } else {
            this.binding.recycler.setAdapter(adapter);
            fetchChannels();
        }
    }

    private void fetchChannels() {
        Context context = getContext();
        NotificationManager manager = context.getSystemService(NotificationManager.class);
        List<NotificationChannel> channels = manager.getNotificationChannels();

        if (this.adapter == null) {
            this.adapter = new ChannelAdapter(context);
            this.adapter.set(channels);
            this.binding.recycler.setAdapter(this.adapter);
        } else {
            this.adapter.set(channels);
            this.adapter.notifyDataSetChanged();
        }
    }
}
