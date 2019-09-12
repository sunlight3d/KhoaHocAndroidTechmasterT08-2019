package com.example.myapp


import android.os.Bundle
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.contact_fragment.*
import android.text.Editable
import android.widget.EditText

class ContactFragment: Fragment(), IMyFragment{
    private lateinit var txtTemp: EditText
    lateinit var person: Person
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.contact_fragment,
            container,
            false)
        txtTemp = view.findViewById(R.id.txtTemp)
        txtTemp.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                person.name = s.toString()
                println("$s, $start, $before, $count, ${person.name}")
            }
        })
        return view
    }

    override fun reloadData() {

    }
}