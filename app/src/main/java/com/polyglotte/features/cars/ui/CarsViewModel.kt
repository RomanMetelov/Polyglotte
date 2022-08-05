package com.polyglotte.features.cars.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarsViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is cars Fragment"
	}
	val text: LiveData<String> = _text
}
