package com.example.bai05.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bai05.R
import com.example.bai05.models.Employer
import kotlinx.android.synthetic.main.employee_item_view.view.*

class EmployerItemView(val view: View):
    RecyclerView.ViewHolder(view) {

    var employer:Employer? = null
        get() = field
        set(value) {
            println("update UI of Employer")
            this.view.txtEmail.text = (value as Employer).email
            this.view.txtAddress.text = (value as Employer).address
            //imageViewAvatar
            field = value
        }

}
