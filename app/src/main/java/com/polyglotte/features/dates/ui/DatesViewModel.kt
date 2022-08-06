package com.polyglotte.features.dates.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DatesViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is dates Fragment"
	}
	val text: LiveData<String> = _text
}
