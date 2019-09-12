package com.example.myapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.main_activity.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        tabLayout.addTab(tabLayout.newTab().setText("Home"))
        tabLayout.addTab(tabLayout.newTab().setText("Contact"))
        tabLayout.addTab(tabLayout.newTab().setText("About"))
        supportActionBar!!.hide()
        var tabs = ArrayList<String>()
        tabs.add("Home")
        tabs.add("Contact")
        tabs.add("About")

        val tabsAdapter = TabsAdapter(this.supportFragmentManager, tabs)
        viewPager.adapter = tabsAdapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                println("you pressed: ${tab!!.position}")
                val fragments = supportFragmentManager.fragments
                val fragment:IMyFragment = fragments[tab!!.position] as IMyFragment
                fragment.reloadData()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}
