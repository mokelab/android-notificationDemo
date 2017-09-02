package com.mokelab.demo.notification

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()

            transaction.add(R.id.container, MainFragment.newInstance())

            transaction.commit()
        }

        supportFragmentManager.addOnBackStackChangedListener {
            val count = supportFragmentManager.backStackEntryCount
            supportActionBar?.setDisplayHomeAsUpEnabled(count > 0)
        }

        // restore current state
        val count = supportFragmentManager.backStackEntryCount
        supportActionBar?.setDisplayHomeAsUpEnabled(count > 0)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                supportFragmentManager.popBackStackImmediate()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
