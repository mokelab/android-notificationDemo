package com.mokelab.demo.notification;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mokelab.demo.notification.databinding.ShowNotificationFragmentBinding;

/**
 * ShowNotificationFragment
 */

public class ShowNotificationFragment extends Fragment {

    private ShowNotificationFragmentBinding binding;

    public static ShowNotificationFragment newInstance() {
        return new ShowNotificationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = ShowNotificationFragmentBinding.inflate(inflater, container, false);

        this.binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

        return this.binding.getRoot();
    }

    private void submit() {
        String id = this.binding.getId();
        String title = this.binding.getTitle();

        NotificationManager manager = getContext().getSystemService(NotificationManager.class);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), id);
        builder.setContentText(title);
        builder.setSmallIcon(R.drawable.ic_add_24dp);

        manager.notify(1, builder.build());
    }
}
