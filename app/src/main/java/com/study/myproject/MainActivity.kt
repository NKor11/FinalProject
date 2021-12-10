package com.study.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.cards -> {
                    fragment = SecondFragment()
                }
                R.id.about -> {
                    fragment = AboutFragment()
                }
            }
            replaceFragment(fragment!!)
            true
        }
        bottomNavigationView.selectedItemId = if (savedInstanceState!=null) savedInstanceState.
        getInt(LAST_SELECTED_ITEM) else R.id.cards
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM,bottomNavigationView.selectedItemId)
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}



