package com.example.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment: Fragment(), IMyFragment{
    private lateinit var textView:TextView
    lateinit var person: Person
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)
        textView = view.findViewById(R.id.textView)

        return view
    }

    override fun reloadData() {
        textView.text = person.name
    }
}