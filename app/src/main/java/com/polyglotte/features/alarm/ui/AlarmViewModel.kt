package com.polyglotte.features.alarm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AlarmViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is alarm Fragment"
	}
	val text: LiveData<String> = _text
}
