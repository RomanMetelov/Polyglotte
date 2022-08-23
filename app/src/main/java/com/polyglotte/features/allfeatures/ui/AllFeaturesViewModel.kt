package com.polyglotte.features.allfeatures.ui

import com.polyglotte.app.common.fromJson
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.polyglotte.app.NavigationActivity
import com.polyglotte.app.data.AppFeatureName
import com.polyglotte.features.allfeatures.domain.RetrofitHelper
import com.polyglotte.features.allfeatures.domain.TestApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class AllFeaturesViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is all features Fragment"
	}
	val text: LiveData<String> = _text

	fun getItemsList(prefs: SharedPreferences): Map<Int, AppFeatureName>? {
		val jsonOrderedFeaturesMap = prefs.getString(NavigationActivity.KEY_APP_FEATURES_ORDERED_LIST, "").toString()
		val dataSet: LiveData<Map<Int, AppFeatureName>> = MutableLiveData<Map<Int, AppFeatureName>>().apply {
			value = Gson().fromJson<Map<Int, AppFeatureName>>(jsonOrderedFeaturesMap)
		}
		return dataSet.value
	}

	private val testApi: TestApi = RetrofitHelper.getInstance().create(TestApi::class.java)
	private val _networkResponse = MutableLiveData<String>().apply {
		MainScope().launch {
			value = testApi.getResponseItem().body()?.count.toString()
		}
	}
	val networkResponse: LiveData<String> = _networkResponse
}
