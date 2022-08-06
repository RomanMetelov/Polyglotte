package com.polyglotte.features.circles.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CirclesViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is circles Fragment"
	}
	val text: LiveData<String> = _text
}
