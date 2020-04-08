package com.example.dagger.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.dagger.BaseActivity
import com.example.dagger.R
import com.example.dagger.ui.main.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun testFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ProfileFragment())
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout){
            sessionManager.logout()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
