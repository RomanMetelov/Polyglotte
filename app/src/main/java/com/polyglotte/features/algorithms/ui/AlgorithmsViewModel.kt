package com.polyglotte.features.algorithms.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AlgorithmsViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is algorithms Fragment"
	}
	val text: LiveData<String> = _text
}
