package com.polyglotte.app

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.polyglotte.R
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

		val navController = findNavController(R.id.nav_host_fragment_activity_navigation)
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		val appBarConfiguration = AppBarConfiguration(
			setOf(
				R.id.navigation_cars, R.id.navigation_crypto, R.id.navigation_menu, R.id.navigation_sports, R.id.navigation_stocks
			)
		)
		setupActionBarWithNavController(navController, appBarConfiguration)
		navView.setupWithNavController(navController)
	}
}

/////////////////////////////////////////////////////////////////
//	private lateinit var binding: ActivityMainBinding
//
//	override fun onCreate(savedInstanceState: Bundle?) {
//		super.onCreate(savedInstanceState)
//		setupBinding()
//
//		val someApi = RetrofitHelper.getInstance().create(SomeApi::class.java)
//		// launching a new coroutine
//		MainScope().launch {
//			val result = someApi.getResponseItem()
//			Log.d("ayush: ", result.body()?.count.toString())
//			delay(5000)
//			binding.result.text = result.body()?.count.toString()
//		}
//	}
//
//
//	//main screen
//	//the app caches the screen and state when it closes
//	//from main screen - languages - books - le comte de monte cristo
//	//on top of the current screen - current languages. If book has no translate to current language - it's transparent
//	//end current second language (by tap on text switch between current1 and current2)
//	//editor (add new books, chapters, translates and...
//	//voice record)
//	//database
//	//export data (whole data with voice record)
//	//save
////////////////////////////////////////////////////////////////////////
