package com.example.bai05

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bai05.models.Employee
import com.example.bai05.views.EmployeeItemView
import kotlinx.android.synthetic.main.employee_item_view.view.*
import kotlinx.android.synthetic.main.login_activity.view.*

//where is your data ?
var employees:ArrayList<Employee> = ArrayList()
fun createFakeEmployees() {
    employees.add(Employee(
        "Le Hoang Dai Duong",
        "konjikinoumi@gmail.com",
        "Apache Friends is a non-profit project to promote the Apache web server and is home to the XAMPP project.",
        "https://upload.wikimedia.org/wikipedia/commons/5/56/Donald_Trump_official_portrait.jpg"))
    employees.add(Employee(
        "Le Hoang Dai Duong2",
        "konjikinoumi@gmail.com",
        "Apache Friends is a non-profit project to promote the Apache web server and is home to the XAMPP project.",
        "https://upload.wikimedia.org/wikipedia/commons/5/56/Donald_Trump_official_portrait.jpg"))
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
    employees.add(Employee(
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

class EmployeeAdapter(val employees: ArrayList<Employee>):
        RecyclerView.Adapter<EmployeeItemView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeItemView {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.employee_item_view, parent, false) as View
        return EmployeeItemView(view)
    }

    override fun onBindViewHolder(holder: EmployeeItemView, position: Int) {
        holder.view.txtName.text = this.employees[position].name
        holder.view.txtAddress.text = this.employees[position].address
        //holder.view.imageViewAvatar
    }

    override fun getItemCount(): Int {
        return this.employees.size
    }
}
