package com.example.empoweringthenation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Six_Weeks : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_six_weeks, container, false)

        val spinnerId = view.findViewById<Spinner>(R.id.spinId)
        val descriptionTextView = view.findViewById<TextView>(R.id.courseDescription)

        val courses = arrayOf("Child Minding", "Cooking", "Garden Maintenance")
        val descriptions = arrayOf(
            "Look after children",
            "Learn to cook affordable and nutritional meals",
            "Learn to take care of and grow a variety of plants",
        )

        val arrayAdp = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, courses)
        spinnerId.adapter = arrayAdp

        spinnerId?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                descriptionTextView.text = descriptions[position]
                descriptionTextView.visibility = View.VISIBLE
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                descriptionTextView.visibility = View.GONE
            }
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Six_Weeks().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
