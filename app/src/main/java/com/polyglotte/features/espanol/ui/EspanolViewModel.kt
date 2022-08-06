package com.polyglotte.features.espanol.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EspanolViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is espanol Fragment"
	}
	val text: LiveData<String> = _text
}
