package com.example.empoweringthenation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.empoweringthenation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemReselectedListener {

            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.Six_Month_Courses -> replaceFragment(Six_Months())
                R.id.Six_Week_Courses -> replaceFragment(Six_Weeks())
                R.id.contact -> replaceFragment(Contact())

                else ->{


                }
            }

            true
        }

    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}