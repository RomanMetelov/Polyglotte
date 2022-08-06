package com.polyglotte.features.selfimprovement.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SelfImprovementViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is self-improvement Fragment"
	}
	val text: LiveData<String> = _text
}
