package com.example.navigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //bottom navigation
         navController = findNavController(R.id.hostFragment)   //main activity xml hostfragment
        //bottom_navigation is the id of our bottom navigation tag
        botton_navigation.setupWithNavController(navController)     // as a parameter pass

        // Navigation Up Button
        appBarConfiguration = AppBarConfiguration(navController.graph,draw_layout)     //graph is imp  //for navigation we add draw_layout

        //arrow will be created by using this as get to backtrack to previous activity
        NavigationUI.setupActionBarWithNavController(this,navController,draw_layout)   //drawlayout is added after bottom and top navigation both are there

        //Drawer Navigation
        NavigationUI.setupWithNavController(navigation_view,navController)

    }

    override fun onSupportNavigateUp(): Boolean {

        return NavigationUI.navigateUp(navController,appBarConfiguration)
    }

    // will be having id as reflecting on the top so go to navigation graph and change the label
}