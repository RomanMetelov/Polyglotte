package com.polyglotte.features.sports.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SportsViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is sports Fragment"
	}
	val text: LiveData<String> = _text
}
