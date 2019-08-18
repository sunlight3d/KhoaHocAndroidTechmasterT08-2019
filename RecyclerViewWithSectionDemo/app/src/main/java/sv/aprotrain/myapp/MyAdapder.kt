package sv.aprotrain.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

var sections: MutableMap<String, ArrayList<Person>> = mutableMapOf()
fun generateSections() {
    sections["Friends"] = ArrayList<Person>()
    sections["Friends"]?.add(Person("hoang", "hoang@gmail.com"))
    sections["Friends"]?.add(Person("hung", "hung@gmail.com"))
    sections["Friends"]?.add(Person("minh", "minh@gmail.com"))

    sections["Colleagues"] = ArrayList<Person>()
    sections["Colleagues"]?.add(Person("alex", "alex@gmail.com"))
    sections["Colleagues"]?.add(Person("john", "john@gmail.com"))

    sections["Others"] = ArrayList<Person>()
    sections["Others"]?.add(Person("aaaxxx", "aaaxxx@gmail.com"))
    sections["Others"]?.add(Person("bbbxxx", "bbbxxx@gmail.com"))
}
fun convertSectionsToArray(sections: MutableMap<String, ArrayList<Person>>): ArrayList<Any>  {
    var dataList:ArrayList<Any> = ArrayList()
    var initKey = ""
    sections.forEach { key, value ->  run {
        if(!key.equals(initKey)) {
            dataList.add(key)
        }
        value.forEach { person -> run {
            dataList.add(person)
        } }
    }}
    return dataList
}

class MyAdapter(private val dataList: ArrayList<Any>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(this.dataList[viewType] is String) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.header_item_view,
                    parent, false) as View
            return HeaderItemView(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.person_item_view,
                    parent, false) as View
            return PersonItemView(view)
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(this.dataList[position] is String) {
            (holder as HeaderItemView).strHeader = this.dataList[position] as String
        } else if(this.dataList[position] is Person) {
            (holder as PersonItemView).person = this.dataList[position] as Person
        }
    }

    override fun getItemCount(): Int {
        return this.dataList.size
    }
}