package com.polyglotte.features.english.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EnglishViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is english Fragment"
	}
	val text: LiveData<String> = _text
}
