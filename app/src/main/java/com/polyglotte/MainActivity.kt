package com.polyglotte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		//main screen
		//the app caches the screen and state when it closes
		//from main screen - languages - books - le comte de monte cristo
		//on top of the current screen - current languages. If book has no translate to current language - it's transparent
		//end current second language (by tap on text switch between current1 and current2)
		//editor (add new books, chapters, translates and...
		//voice record)
		//database
		//export data (whole data with voice record)
		//save
	}
}