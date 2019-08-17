package com.example.bai05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.employees_activity.*

class EmployeesActivity : AppCompatActivity() {
    private lateinit var employeesAdapter: RecyclerView.Adapter<*>
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.employees_activity)
        setupRecyclerView()
    }
    private fun setupRecyclerView() {
        layoutManager =  LinearLayoutManager(this)

        createFakeEmployees()
        employeesAdapter = EmployeeAdapter(employees)

        recyclerViewEmployees.adapter = employeesAdapter
        recyclerViewEmployees.setHasFixedSize(true)
        recyclerViewEmployees.layoutManager = layoutManager
    }
}
