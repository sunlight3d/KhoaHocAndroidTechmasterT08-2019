package com.example.myapp

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.person_item_view.view.*

class PersonItemView(val view: View):
    RecyclerView.ViewHolder(view) {
    var person:Person? = null
        set(value) {
            println("update UI")
            this.view.txtName.text = value?.name
            this.view.txtAge.text = value?.age.toString()
            field = value
        }

}
