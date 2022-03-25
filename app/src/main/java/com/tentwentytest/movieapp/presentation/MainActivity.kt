package com.tentwentytest.movieapp.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.tentwentytest.movieapp.R
import com.tentwentytest.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_fragment)
        val radius = resources.getDimension(R.dimen._18sdp)
        val shapeDrawable : MaterialShapeDrawable = mainBinding.navView.background as MaterialShapeDrawable
        shapeDrawable.shapeAppearanceModel = shapeDrawable.shapeAppearanceModel
            .toBuilder()
            .setTopLeftCorner(CornerFamily.ROUNDED, radius)
            .setTopRightCorner(CornerFamily.ROUNDED, radius)
            .build()
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_dashboard,
            R.id.navigation_watch,
            R.id.navigation_notifications,
            R.id.navigation_more
        ))

        setupActionBarWithNavController(navController, appBarConfiguration)
        //mainBinding.layoutToolbar.toolbar.setupWithNavController(navController, appBarConfiguration)
        mainBinding.navView.setupWithNavController(navController)
        val item: MenuItem = mainBinding.navView.getMenu().findItem(R.id.navigation_watch)
        item.setChecked(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search, menu)

        return true
    }
}