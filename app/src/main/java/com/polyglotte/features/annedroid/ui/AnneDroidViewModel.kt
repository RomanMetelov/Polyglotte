package com.polyglotte.features.annedroid.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnneDroidViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is Anne Droid Fragment"
	}
	val text: LiveData<String> = _text
}
