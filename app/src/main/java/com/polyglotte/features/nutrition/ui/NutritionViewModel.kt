package com.polyglotte.features.nutrition.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NutritionViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is nutrition Fragment"
	}
	val text: LiveData<String> = _text
}
