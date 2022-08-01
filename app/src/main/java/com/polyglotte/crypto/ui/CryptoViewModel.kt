package com.polyglotte.crypto.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CryptoViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is crypto Fragment"
	}
	val text: LiveData<String> = _text
}
