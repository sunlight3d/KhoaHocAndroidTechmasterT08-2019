package com.example.myapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class TabsAdapter(fragmentManager: FragmentManager,
                  private val tabs: ArrayList<String>) :
            FragmentStatePagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return tabs.size
    }

    override fun getItem(position: Int): Fragment? {
        when(position) {
            0 -> {
                return HomeFragment()
            }
            1 ->{
                return ContactFragment()
            }
            2 ->{
                return AboutFragment()
            }
            else ->{
                return null
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabs[position]
    }
}