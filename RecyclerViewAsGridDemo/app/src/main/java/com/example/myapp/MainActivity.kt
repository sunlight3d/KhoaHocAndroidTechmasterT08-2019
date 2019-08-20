package com.example.myapp

import android.app.Activity
import android.content.res.Configuration
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if(this.resources.configuration.orientation == ORIENTATION_LANDSCAPE) {
            layoutManager = GridLayoutManager(this,4)
        } else {
            layoutManager = GridLayoutManager(this,3)
        }


        generatePersons()
        adapter = MyAdapter(persons)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        if(newConfig?.orientation == ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "ORIENTATION_LANDSCAPE", Toast.LENGTH_LONG).show()
            layoutManager.spanCount = 4
        }else {
            Toast.makeText(this, "ORIENTATION_PORTRAIT", Toast.LENGTH_LONG).show()
            layoutManager.spanCount = 3
        }
        super.onConfigurationChanged(newConfig)
    }
}
