package com.polyglotte.features.handmade.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HandmadeViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is handmade Fragment"
	}
	val text: LiveData<String> = _text
}
