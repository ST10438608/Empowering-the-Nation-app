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


class Six_Weeks : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var childMindingImage: ImageView
    private lateinit var cookingImage: ImageView
    private lateinit var gardenImage: ImageView

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

        childMindingImage = view.findViewById(R.id.childmindingImage)
        cookingImage = view.findViewById(R.id.cookingImage)
        gardenImage = view.findViewById(R.id.gardenImage)

        childMindingImage.setOnClickListener {
            // Navigate to other screen
            findNavController().navigate(R.id.action_Six_Weeks_to_Child_Minding)
        }

        cookingImage.setOnClickListener {

            findNavController().navigate(R.id.action_Six_Weeks_to_Cooking)
        }

        gardenImage.setOnClickListener {

            findNavController().navigate(R.id.action_Six_Weeks_to_Garden_Maintenance)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // To reduce memory usage and avoid crashes

        Glide.with(this)
            .load(R.drawable.childminding)
            .into(childMindingImage)

        Glide.with(this)
            .load(R.drawable.cooking)
            .into(cookingImage)

        Glide.with(this)
            .load(R.drawable.gardenmaintenance)
            .into(gardenImage)

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
