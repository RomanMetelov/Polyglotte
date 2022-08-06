package com.polyglotte.features.deutsch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DeutschViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is deutsch Fragment"
	}
	val text: LiveData<String> = _text
}
