package com.hafidmust.moviecatalogue3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hafidmust.moviecatalogue3.databinding.ActivityMainBinding


import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.hafidmust.moviecatalogue3.ui.favorite.FavoriteActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = binding.navView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        if (bottomNavigationView != null){
            NavigationUI.setupWithNavController(
                bottomNavigationView, navHostFragment.navController
            )
        }
    }
    fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }


//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.menu_to_fav, menu)
//        //getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.action_to_favorite){
//            startActivity(Intent(this, FavoriteActivity::class.java))
//        }
//        return true
//    }
}