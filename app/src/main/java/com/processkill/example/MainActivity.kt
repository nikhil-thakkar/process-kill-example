package com.processkill.example

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Do you know the reason for this null check? Do leave your comments here:
        //https://bit.ly/wheres-my-process
        if (savedInstanceState == null) {
            supportFragmentManager.replaceFragment(R.id.fragment_container, MainFragment.newInstance())
        }

        //to correctly restore the state of actionbar in case of process kill
        supportActionBar?.setDisplayHomeAsUpEnabled(supportFragmentManager.backStackEntryCount >= 1)

        supportFragmentManager.addOnBackStackChangedListener {
            supportActionBar?.setDisplayHomeAsUpEnabled(supportFragmentManager.backStackEntryCount >= 1)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

fun FragmentManager.replaceFragment(containerId: Int, fragment: Fragment, addToBackStack: Boolean = false) {
    val transaction = beginTransaction().replace(containerId, fragment)

    if (addToBackStack) transaction.addToBackStack(fragment::class.java.canonicalName)

    transaction.commit()
}

fun FragmentManager.addFragment(containerId: Int, fragment: Fragment, addToBackStack: Boolean = false) {
    val transaction = beginTransaction().add(containerId, fragment)

    if (addToBackStack) transaction.addToBackStack(fragment::class.java.canonicalName)

    transaction.commit()
}
