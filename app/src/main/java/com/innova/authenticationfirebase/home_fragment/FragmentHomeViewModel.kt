package com.innova.authenticationfirebase.home_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _navigateToBillDetails = MutableLiveData<Boolean>()
    val navigateToBillDetails: LiveData<Boolean>
        get() = _navigateToBillDetails

    private val _navigateToMaps = MutableLiveData<Boolean>()
    val navigateToMaps: LiveData<Boolean>
        get() = _navigateToMaps

    init {
        _navigateToBillDetails.value = false
        _navigateToMaps.value = false
    }

    fun onBillButtonClick() {
        _navigateToBillDetails.value = true
    }

    fun onMapsButtonClick() {
        _navigateToMaps.value = true
    }

    fun onNavigationComplete() {
        _navigateToBillDetails.value = false
        _navigateToMaps.value = false
    }


}