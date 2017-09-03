package com.mokelab.demo.notification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 *
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.add(R.id.container, MainFragment.newInstance());

            transaction.commit();
        }

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                int count = getSupportFragmentManager().getBackStackEntryCount();
                ActionBar actionBar = getSupportActionBar();
                if (actionBar == null) { return; }
                actionBar.setDisplayHomeAsUpEnabled(count > 0);
            }
        });

        // restore current state
        int count = getSupportFragmentManager().getBackStackEntryCount();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) { return; }
        actionBar.setDisplayHomeAsUpEnabled(count > 0);
    }
}
