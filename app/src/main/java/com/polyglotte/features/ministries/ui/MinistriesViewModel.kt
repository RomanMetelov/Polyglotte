package com.polyglotte.features.ministries.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MinistriesViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is ministries Fragment"
	}
	val text: LiveData<String> = _text
}
