package com.mokelab.demo.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mokelab.demo.notification.databinding.CreateChannelFragmentBinding;

/**
 * CreateChannelFragment shows a form
 */

public class CreateChannelFragment extends Fragment {

    private CreateChannelFragmentBinding binding;

    public static CreateChannelFragment newInstance() {
        return new CreateChannelFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = CreateChannelFragmentBinding.inflate(inflater, container, false);


        this.binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

        return this.binding.getRoot();
    }

    private void submit() {
        String id = this.binding.getId();
        String name = this.binding.getName();
        String description = this.binding.getDescription();

        NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription(description);

        NotificationManager manager = getContext().getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

        getFragmentManager().popBackStackImmediate();
    }
}
