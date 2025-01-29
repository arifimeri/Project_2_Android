package com.example.project2.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    // A list of photo URLs or paths.
    private val _photos = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf()
    }

    // Public LiveData for the photos
    val photos: LiveData<MutableList<String>> = _photos

    // A method to add a photo
    fun addPhoto(photoUrl: String) {
        _photos.value?.add(photoUrl)
        _photos.value = _photos.value // Trigger observers
    }

    // A method to remove a photo
    fun removePhoto(photoUrl: String) {
        _photos.value?.remove(photoUrl)
        _photos.value = _photos.value // Trigger observers
    }

    // You can add other methods for updating or manipulating the photo list as needed.
}
