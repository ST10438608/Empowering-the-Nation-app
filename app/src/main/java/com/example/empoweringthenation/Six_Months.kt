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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Six_Months.newInstance] factory method to
 * create an instance of this fragment.
 */
class Six_Months : Fragment() {
    // TODO: Rename and change types of parameters
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
        val view = inflater.inflate(R.layout.fragment_six_months, container, false)

        val spinnerId = view.findViewById<Spinner>(R.id.spinId)
        val descriptionTextView = view.findViewById<TextView>(R.id.courseDescription)

        val courses = arrayOf("First-Aid", "Sewing", "Landscaping", "Life Skills")
        val descriptions = arrayOf(
            "Learn essential first-aid techniques.",
            "Master the basics of sewing.",
            "Explore landscaping and garden design.",
            "Develop essential life skills for success."
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Settings.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Six_Months().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
