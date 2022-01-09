package com.languagexx.simplenotes.ui

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.languagexx.simplenotes.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    lateinit var navController: NavController

    // Method #1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.container)

        val root_layout=findViewById<View>(R.id.root_layout)

        val animDrawable=root_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(50)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()


        //Floating action button will redirect to Add New Notes Fragment #AddFragment
        fab.setOnClickListener {
            onFloatingClicked()
        }
    }

    // Method #2
    private fun onFloatingClicked() {
        navController.navigate(R.id.action_listFragment_to_addFragment)
        fab.hide()
    }

    // Method #3
    fun showFloatingButton(){
        fab.show()
        fab.visibility = View.VISIBLE
    }
}