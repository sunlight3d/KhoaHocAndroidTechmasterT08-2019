package sv.aprotrain.myapp

import android.graphics.Color
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
            this.view.txtHeader.setTextColor(Color.RED)
            this.view.setBackgroundColor(Color.GREEN)
            field = value
        }

}