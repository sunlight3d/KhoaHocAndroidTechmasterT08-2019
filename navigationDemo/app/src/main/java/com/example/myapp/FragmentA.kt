package com.example.myapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment.findNavController

class FragmentA : Fragment() {

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var btnNavigate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //2
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //3
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        btnNavigate = view.findViewById(R.id.btnNavigate)
        btnNavigate.setOnClickListener { v -> run{
            val nav = findNavController(this@FragmentA)
            nav.navigate(R.id.action_fragmentA_to_fragmentB, bundleOf("name" to "Hoang"))
        } }
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context) //1
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}
