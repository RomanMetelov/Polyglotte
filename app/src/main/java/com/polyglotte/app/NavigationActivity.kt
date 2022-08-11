package com.polyglotte.app

import android.os.Bundle
import android.view.Menu
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.polyglotte.app.navigation.BottomNavBarMenuItemsUseCase
import com.polyglotte.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {

	private lateinit var binding: ActivityNavigationBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setupBinding()
		setupBottomNavigation()
	}

	private fun setupBinding() {
		binding = ActivityNavigationBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}

	private fun setupBottomNavigation() {
		val navView: BottomNavigationView = binding.navView
		val navController = binding.appNavHostFragment.getFragment<NavHostFragment>().navController

		navView.menu.clear()

		val topLevelDestinationsSet = mutableSetOf<Int>()

		BottomNavBarMenuItemsUseCase().get().forEachIndexed { index, menuItem ->
			navView.menu.add(Menu.NONE, menuItem.destinationId, index, menuItem.labelId).setIcon(menuItem.imageId)
			topLevelDestinationsSet.add(menuItem.destinationId)
		}

		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		val appBarConfiguration = AppBarConfiguration(
			topLevelDestinationsSet.toSet()
		)
		setupActionBarWithNavController(navController, appBarConfiguration)
		navView.setupWithNavController(navController)
	}
}
