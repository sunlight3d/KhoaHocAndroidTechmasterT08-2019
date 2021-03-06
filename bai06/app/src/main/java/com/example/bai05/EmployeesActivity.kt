package com.example.bai05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.employees_activity.*

class EmployeesActivity : AppCompatActivity() {
    private lateinit var recyclerViewEmployees: RecyclerView

    private lateinit var employeesAdapter: RecyclerView.Adapter<*>
    private lateinit var layoutManager2: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.employees_activity)
        setupRecyclerView()
    }
    private fun setupRecyclerView() {
        layoutManager2 =  LinearLayoutManager(this)
        employeesAdapter = EmployeeAdapter(employees)
        recyclerViewEmployees = findViewById<RecyclerView>(R.id.recyclerViewEmployees).apply{
            adapter = employeesAdapter
            setHasFixedSize(true)
            layoutManager = layoutManager2
        }
    }
}
