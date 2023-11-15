package com.innova.authenticationfirebase.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.innova.authenticationfirebase.R
import com.innova.authenticationfirebase.home_fragment.FragmentHome
import com.innova.authenticationfirebase.view.FragmentProfile

class MainViewModel : ViewModel() {

    private val fragmentHome = FragmentHome()
    private val fragmentProfile = FragmentProfile()

    // BottomNavigationView'da seçilen öğeye göre fragment döndüren LiveData
    private val _selectedFragment = MutableLiveData<Fragment>()
    val selectedFragment: LiveData<Fragment> = _selectedFragment

    init {
        // Başlangıçta fragmentHome'u seçili olarak ayarlayın.
        _selectedFragment.value = fragmentHome
    }

    fun onNavigationItemSelected(itemId: Int) {
        when (itemId) {
            R.id.navHome -> _selectedFragment.value = fragmentHome
            R.id.navProfile -> _selectedFragment.value = fragmentProfile
        }
    }

    private val _navigateToMaps = MutableLiveData<Boolean>()
    val navigateToMaps: LiveData<Boolean>
        get() = _navigateToMaps


}
