package com.example.empoweringthenation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.empoweringthenation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> navController.navigate(R.id.home)
                R.id.Six_Month_Courses -> navController.navigate(R.id.Six_Months)
                R.id.Six_Week_Courses -> navController.navigate(R.id.Six_Weeks)
                R.id.contact -> navController.navigate(R.id.contact) // Use navController for Contact
            }
            true
        }

        binding.bottomNavigationView.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.home -> navController.navigate(R.id.home)
                R.id.Six_Month_Courses -> navController.navigate(R.id.Six_Months)
                R.id.Six_Week_Courses -> navController.navigate(R.id.Six_Weeks)
                R.id.contact -> navController.navigate(R.id.contact)
            }
        }
    }
}