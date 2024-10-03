package com.example.empoweringthenation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Six_Months : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var firstAidImage: ImageView
    private lateinit var sewingImage: ImageView
    private lateinit var landscapingImage: ImageView
    private lateinit var lifeSkillsImage: ImageView

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

        firstAidImage = view.findViewById(R.id.firstAidImage)
        sewingImage = view.findViewById(R.id.sewingImage)
        landscapingImage = view.findViewById(R.id.landscapingImage)
        lifeSkillsImage = view.findViewById(R.id.lifeSkillsImage)

        firstAidImage.setOnClickListener {
            // Navigate to the other page (Fragment or Activity)
            findNavController().navigate(R.id.action_Six_Months_to_First_Aid)
        }

        sewingImage.setOnClickListener {
            // Navigate to the other page (Fragment or Activity)
            findNavController().navigate(R.id.action_Six_Months_to_Sewing)
        }

        landscapingImage.setOnClickListener {
            // Navigate to the other page (Fragment or Activity)
            findNavController().navigate(R.id.action_Six_Months_to_Landscaping)
        }

        lifeSkillsImage.setOnClickListener {
            // Navigate to the other page (Fragment or Activity)
            findNavController().navigate(R.id.action_Six_Months_to_Life_Skills)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this)
            .load(R.drawable.landscaping)
            .into(landscapingImage)

    }

    companion object {

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
