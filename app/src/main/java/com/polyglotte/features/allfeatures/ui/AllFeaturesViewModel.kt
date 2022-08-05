package com.polyglotte.features.allfeatures.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polyglotte.features.allfeatures.domain.RetrofitHelper
import com.polyglotte.features.allfeatures.domain.TestApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class AllFeaturesViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is all features Fragment"
	}
	val text: LiveData<String> = _text

	private val testApi: TestApi = RetrofitHelper.getInstance().create(TestApi::class.java)
	private val _networkResponse = MutableLiveData<String>().apply {
		MainScope().launch {
			value = testApi.getResponseItem().body()?.count.toString()
		}
	}
	val networkResponse: LiveData<String> = _networkResponse

}
