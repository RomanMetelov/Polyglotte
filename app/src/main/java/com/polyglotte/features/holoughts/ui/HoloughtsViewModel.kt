package com.polyglotte.features.holoughts.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HoloughtsViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is holoughts Fragment"
	}
	val text: LiveData<String> = _text
}
