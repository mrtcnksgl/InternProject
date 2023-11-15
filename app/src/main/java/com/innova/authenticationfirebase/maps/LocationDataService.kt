package com.innova.authenticationfirebase.maps

import com.google.android.gms.maps.model.LatLng

class LocationDataService {
    val locations: List<Location> = listOf(
        Location(
            name = "İnnova Ankara",
            cityName = "ANKARA",
            coordinates = LatLng(39.897931928594666, 32.770711198457235)
        ),
        Location(
            name = "İnnova Istanbul",
            cityName = "ISTANBUL",
            coordinates = LatLng(41.10755, 29.02771)
        ),
        Location(
            name = "İnnova AR-GE Ofisi Umraniye",
            cityName = "ISTANBUL",
            coordinates = LatLng(41.02706, 29.12276)
        ),
        Location(
            name = "İnnova Izmir",
            cityName = "İZMİR",
            coordinates = LatLng(38.45529, 27.18090)
        ),
        Location(
            name = "İnnova Antalya",
            cityName = "ANTALYA",
            coordinates = LatLng(36.87990, 30.73366)
        ),
        Location(
            name = "İnnova Adana",
            cityName = "ADANA",
            coordinates = LatLng(37.03398, 35.31494)
        ),
        Location(
            name = "İnnova Erzurum",
            cityName = "ERZURUM",
            coordinates = LatLng(39.90508, 41.27917)
        ),
        Location(
            name = "İnnova Samsun",
            cityName = "SAMSUN",
            coordinates = LatLng(41.28032, 36.33623)
        ),
        Location(
            name = "İnnova Bursa",
            cityName = "BURSA",
            coordinates = LatLng(40.20816, 29.02020)
        ),
        Location(
            name = "İnnova Diyarbakır",
            cityName = "DİYARBAKIR",
            coordinates = LatLng(37.91788, 40.22018)
        ),
        Location(
            name = "İnnova Kayseri",
            cityName = "KAYSERİ",
            coordinates = LatLng(38.72680, 35.50437)
        )
    )

}

data class Location(
    val name: String,
    val cityName: String,
    val coordinates: LatLng
)
