package com.example.myapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class TabsAdapter(fragmentManager: FragmentManager,
                  private val tabs: ArrayList<String>) :
            FragmentStatePagerAdapter(fragmentManager) {
    private var person = Person("",18)
    override fun getCount(): Int {
        return tabs.size
    }

    override fun getItem(position: Int): Fragment? {
        when(position) {
            0 -> {
                val homeFragment = HomeFragment()
                homeFragment.person = person
                return homeFragment
            }
            1 ->{
                val contactFragment = ContactFragment()
                contactFragment.person = person
                return contactFragment
            }
            2 ->{
                val aboutFragment = AboutFragment()
                aboutFragment.person = person
                return aboutFragment
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