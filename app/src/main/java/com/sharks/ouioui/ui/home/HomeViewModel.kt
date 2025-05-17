package com.sharks.ouioui.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharks.ouioui.data.model.PlaceShort
import com.sharks.ouioui.repository.DestinationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: DestinationRepository) : ViewModel() {

    private val _places = MutableLiveData<List<PlaceShort>>()
    val places: LiveData<List<PlaceShort>> = _places

    fun loadNearbyPlaces() {
        viewModelScope.launch {
            val results = repository.getNearbyPlaces(
                lat = 48.8584,
                lon = 2.2945,
                radius = 1000
            )
            _places.value = results ?: emptyList()
        }
    }
}