package com.polyglotte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.polyglotte.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setupBinding()
//		setupOnClickListeners()

		val someApi = RetrofitHelper.getInstance().create(SomeApi::class.java)
		// launching a new coroutine
		MainScope().launch {
			val result = someApi.getResponseItem()
			Log.d("ayush: ", result.body()?.count.toString())
			delay(5000)
			binding.result.text = result.body()?.count.toString()
		}
	}

	private fun setupBinding() {
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}

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

object RetrofitHelper {

	private const val baseUrl = "https://polyglotte-lycra.ondigitalocean.app"

	fun getInstance(): Retrofit {
		return Retrofit.Builder().baseUrl(baseUrl)
			.addConverterFactory(GsonConverterFactory.create())
			// we need to add converter factory to
			// convert JSON object to Java object
			.build()
	}
}

interface SomeApi {
	@GET("/")
	suspend fun getResponseItem(): Response<SomeDataClass>
}

data class SomeDataClass(
	val count: Int
)
