package com.polyglotte.features.francais.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FrancaisViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is francais Fragment"
	}
	val text: LiveData<String> = _text
}
