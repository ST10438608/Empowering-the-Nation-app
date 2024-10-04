package com.example.empoweringthenation

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Fees : AppCompatActivity() {
    private lateinit var spinnerId: Spinner
    private lateinit var checkBoxContainer: LinearLayout
    private val sixMonthsSelections = mutableListOf<String>()
    private val sixWeeksSelections = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fees)

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        spinnerId = findViewById(R.id.spinId)
        checkBoxContainer = findViewById(R.id.checkBoxContainer)

        val courses = arrayOf("Six Months", "Six Weeks")
        val adapter: SpinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, courses)
        spinnerId.adapter = adapter


        spinnerId?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateCheckboxes(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener {
            val allSelections = sixMonthsSelections + sixWeeksSelections
            calculateFees(allSelections.toTypedArray())
        }



    }

    private fun updateCheckboxes(position: Int) {
        checkBoxContainer.removeAllViews()
        val options = if (position == 0) { // Six Months
            arrayOf("First Aid", "Sewing", "Landscaping", "Life Skills")
        } else { // Six Weeks
            arrayOf("Child Minding", "Cooking", "Garden Maintenance")
        }
        addCheckBoxes(options)
    }


    private fun addCheckBoxes(options: Array<String>) {
        for (option in options) {
            val checkBox = CheckBox(this)
            checkBox.text = option
            checkBox.setTextColor(ContextCompat.getColor(this, R.color.white))
            checkBox.textSize = 20f
            checkBox.setPadding(16, 16, 16, 16)

            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    if (spinnerId.selectedItemPosition == 0) {
                        sixMonthsSelections.add(option)
                    } else {
                        sixWeeksSelections.add(option)
                    }
                } else {
                    if (spinnerId.selectedItemPosition == 0) {
                        sixMonthsSelections.remove(option)
                    } else {
                        sixWeeksSelections.remove(option)
                    }
                }
            }

            checkBoxContainer.addView(checkBox) // Add only once
        }
    }

    internal fun showFeesPopup(totalFees: Double) {
        val popupView = layoutInflater.inflate(R.layout.popup_fees, null) // Use layoutInflater directly
        val popupWindow = PopupWindow(
            popupView,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            true
        )
        popupWindow.isOutsideTouchable = false
        val feesTextView = popupView.findViewById<TextView>(R.id.feesTextView)
        feesTextView.text = "Total Fees: R$totalFees"
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
        val okButton = popupView.findViewById<Button>(R.id.okButton)
        okButton.setOnClickListener {
            popupWindow.dismiss()
        }
    }

    fun calculateFees(selectedCourses: Array<String>) {
        // Calculate the total fees based on the selected courses
        var totalFees = 0.0
        val courseCount = selectedCourses.size

        for (course in selectedCourses) {
            when (course) {
                "First Aid", "Sewing", "Landscaping", "Life Skills" -> totalFees += 1500.0
                "Child Minding", "Cooking", "Garden Maintenance" -> totalFees += 750.0
            }
        }
        // Calculate the discount based on the number of courses
        val discount = when {
            courseCount == 2 -> 0.05 // 5% discount
            courseCount == 3 -> 0.10 // 10% discount
            courseCount > 3 -> 0.15 // 15% discount
            else -> 0.0 // No discount
        }

        val finalFees = totalFees * (1 - discount)

        showFeesPopup(finalFees)
    }
}







