package sv.aprotrain.myapp

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
            //this.view.imageViewUrl
            field = value
        }

}