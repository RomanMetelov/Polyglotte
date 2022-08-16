package com.polyglotte.app

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.gson.Gson
import com.polyglotte.app.common.fromJson
import com.polyglotte.app.data.AppFeatureName
import com.polyglotte.app.data.AppFeaturesRepository
import com.polyglotte.app.data.AppFeaturesRepositoryItem
import com.polyglotte.app.data.AppFeaturesDefaultOrderRepository
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
		val bottomNavigationMenuItemsList = getBottomNavigationMenuItemsList()
		val topLevelDestinationsSet = mutableSetOf<Int>()

		navView.menu.clear()
		bottomNavigationMenuItemsList.forEachIndexed { index, menuItem ->
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

	private fun getBottomNavigationMenuItemsList(): List<AppFeaturesRepositoryItem> {

		val prefs: SharedPreferences = getSharedPreferences(PREFERENCES_NAVIGATION, Context.MODE_PRIVATE)
		val jsonOrderedFeaturesMap = prefs.getString(KEY_APP_FEATURES_ORDERED_LIST, null)
		val orderedFeaturesMap: Map<Int, AppFeatureName>

		if (jsonOrderedFeaturesMap.isNullOrEmpty()) {//if the file prefs is not exist what this condition returns?
			orderedFeaturesMap = AppFeaturesDefaultOrderRepository.get()
			prefs.edit {
				putString(KEY_APP_FEATURES_ORDERED_LIST, Gson().toJson(orderedFeaturesMap))
				apply()
			}
		} else {
			orderedFeaturesMap = Gson().fromJson<Map<Int, AppFeatureName>>(jsonOrderedFeaturesMap)
		}

		val maxBottomNavMenuItemsKeysListSize = 5

		val bottomNavMenuItemsKeysListSize = Integer.min(maxBottomNavMenuItemsKeysListSize, orderedFeaturesMap.size)

		//TODO starts
		val bottomNavMenuItemsKeysList: MutableList<AppFeatureName> =
			orderedFeaturesMap.values.toList().subList(0, bottomNavMenuItemsKeysListSize)
				.toMutableList()//what if bottomNavMenuItemsKeysListSize=0?

		bottomNavMenuItemsKeysList[bottomNavMenuItemsKeysList.lastIndex] =
			AppFeatureName.ALL//and no last index because bottomNavMenuItemsKeysList=null or listOf()?
		//this list should be initiated with null items, then filterNotNull.... ALL_FEATURES must be ALWAYS added to this list
		//more checks should be added
		//and after adding checks look at this method and rewrite it
		//TODO ends

		val features: MutableList<AppFeaturesRepositoryItem?> = mutableListOf()

		bottomNavMenuItemsKeysList.forEach { key ->
			features.add(AppFeaturesRepository.getFeaturesListItemByKey(key))
		}

		return features.filterNotNull().toList()
	}

	companion object {
		const val PREFERENCES_NAVIGATION = "nav_prefs" //filename
		const val KEY_APP_FEATURES_ORDERED_LIST = "KEY_APP_FEATURES_ORDERED_LIST"
	}
}
