package com.rigo.teloslabschallengemobile.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rigo.teloslabschallengemobile.Fragments.HomeFragment
import com.rigo.teloslabschallengemobile.Fragments.RentCarFragment
import com.rigo.teloslabschallengemobile.Fragments.SearchFragment
import com.rigo.teloslabschallengemobile.R
import com.rigo.teloslabschallengemobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            menuItem ->
            when(menuItem.itemId){
                R.id.nav_home -> {
                    val fragment = HomeFragment.newInstance()
                    openFragment(fragment)
                    true
                }

                R.id.nav_search -> {
                    val fragment = SearchFragment.newInstance()
                    openFragment(fragment)
                    true
                }

                R.id.nav_cart -> {
                    val fragment = RentCarFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }

        binding.bottomNavigation.selectedItemId = R.id.nav_home
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentLayout, fragment)
        transaction.commit()
    }

}