package sv.aprotrain.myapp

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.header_item_view.view.*

class HeaderItemView(val view: View):
    RecyclerView.ViewHolder(view) {
    var strHeader:String = ""
        set(value) {
            println("update UI")
            this.view.txtHeader.text = value
            field = value
        }

}