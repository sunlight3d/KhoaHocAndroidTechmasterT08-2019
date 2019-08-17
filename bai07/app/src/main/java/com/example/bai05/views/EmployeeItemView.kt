package com.example.bai05.views

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.bai05.models.Employee
import kotlinx.android.synthetic.main.employee_item_view.view.*

class EmployeeItemView(val view: View):
        RecyclerView.ViewHolder(view) {
        var employee:Employee? = null
                set(value) {
                        println("update UI")
                        this.view.txtEmail.text = value?.name
                        this.view.txtAddress.text = value?.address
                        val uri = Uri.parse(value?.urlAvatar)
//                        this.view.imageViewAvatar.setImageURI(uri)
                        this.view.setOnClickListener { println("click = ${value?.name}") }
                        field = value
                }

}
