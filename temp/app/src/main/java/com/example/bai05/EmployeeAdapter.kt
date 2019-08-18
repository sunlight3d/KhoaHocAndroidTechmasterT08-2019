package com.example.bai05

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bai05.models.Employee
import com.example.bai05.models.Employer
import com.example.bai05.views.EmployeeItemView
import com.example.bai05.views.EmployerItemView
import kotlinx.android.synthetic.main.employee_item_view.view.*
import kotlinx.android.synthetic.main.login_activity.view.*

//where is your data ?
var employees:ArrayList<Any> = ArrayList()
fun createFakeEmployees() {
    employees.add(Employee(
        "Le Hoang Dai Duong",
        "konjikinoumi@gmail.com",
        "XXXApache Friends is a non-profit project to promote the Apache web Apache Friends is a non-profit project to promote the Apache web serApache Friends is a non-profit project to promote the Apache web serApache Friends is a non-profit project to promApache Friends is a non-profit project to promote the Apache web serote the Apache web serserver and is home to the XAMPP project.XXX",
        "https://upload.wikimedia.org/wikipedia/commons/5/56/Donald_Trump_official_portrait.jpg"))
    employees.add(Employer(
        "Le Hoang Dai Duong2",
        "konjikinoumi@gmail.com",
        "Apache Friends is a non-profit project to promote the Apache web server and is home to the XAMPP project.",
        "https://upload.wikimedia.org/wikipedia/commons/5/56/Donald_Trump_official_portrait.jpg")
    )
    employees.add(Employee(
        "Le Hoang Dai Duong3",
        "konjikinoumi@gmail.com",
        "Apache Friends is a non-profit project to promote the Apache web server and is home to the XAMPP project.",
        "https://upload.wikimedia.org/wikipedia/commons/5/56/Donald_Trump_official_portrait.jpg"))
    employees.add(Employee(
        "Le Hoang Dai Duong4",
        "konjikinoumi@gmail.com",
        "Apache Friends is a non-profit project to promote the Apache web server and is home to the XAMPP project.",
        "https://upload.wikimedia.org/wikipedia/commons/5/56/Donald_Trump_official_portrait.jpg"))
    employees.add(Employer(
        "Le Hoang Dai Duong5",
        "konjikinoumi@gmail.com",
        "Apache Friends is a non-profit project to promote the Apache web server and is home to the XAMPP project.",
        "https://upload.wikimedia.org/wikipedia/commons/5/56/Donald_Trump_official_portrait.jpg"))
    employees.add(Employee(
        "Le Hoang Dai Duong",
        "konjikinoumi@gmail.com",
        "Apache Friends is a non-profit project to promote the Apache web server and is home to the XAMPP project.",
        "https://upload.wikimedia.org/wikipedia/commons/5/56/Donald_Trump_official_portrait.jpg"))
}

class EmployeeAdapter(private val employees: ArrayList<Any>):
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return position;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(this.employees[viewType] is Employee) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.employee_item_view,
                    parent, false) as View
            return EmployeeItemView(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.employer_item_view,
                    parent, false) as View
            return EmployerItemView(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(this.employees[position] is Employee) {
            (holder as EmployeeItemView).employee = (this.employees[position] as Employee)
        } else if(this.employees[position] is Employer) {
            (holder as EmployerItemView).employer = (this.employees[position] as Employer)
        }


    }

    override fun getItemCount(): Int {
        return this.employees.size
    }
}
