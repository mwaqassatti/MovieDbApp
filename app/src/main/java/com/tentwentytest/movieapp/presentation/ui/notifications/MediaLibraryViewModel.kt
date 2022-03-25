package com.tentwentytest.movieapp.presentation.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MediaLibraryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is MediaLibrary Fragment"
    }
    val text: LiveData<String> = _text
}