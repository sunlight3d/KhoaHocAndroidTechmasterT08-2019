package com.example.myapp
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
var persons:ArrayList<Person> = ArrayList()
fun generatePersons() {
    persons.add(Person("AAa", 18))
    persons.add(Person("BBB", 19))
    persons.add(Person("CCC", 20))
    persons.add(Person("DDD", 22))
    persons.add(Person("EEE", 25))
    persons.add(Person("fff", 27))
    persons.add(Person("GGG", 29))


}
class MyAdapter(private val persons: ArrayList<Person>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return position
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_item_view,
                parent, false) as View
        return PersonItemView(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PersonItemView).person = this.persons[position]
        if(position % 2 == 0) {
            holder.view.setBackgroundColor(Color.GREEN)
        }else {
            holder.view.setBackgroundColor(Color.RED)
        }

    }

    override fun getItemCount(): Int {
        return this.persons.size
    }
}