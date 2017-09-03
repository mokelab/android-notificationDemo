package com.mokelab.demo.notification;

import android.app.NotificationChannel;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mokelab.demo.notification.databinding.ChannelItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * ChannelAdapter
 */

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ViewHolder> {


    private final LayoutInflater inflater;
    private final ArrayList<NotificationChannel> items = new ArrayList<>();

    public ChannelAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public void set(List<NotificationChannel> items) {
        this.items.clear();
        this.items.addAll(items);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ChannelItemBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.setChannel(items.get(position));
        holder.binding.executePendingBindings();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ChannelItemBinding binding;

        public ViewHolder(ChannelItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
