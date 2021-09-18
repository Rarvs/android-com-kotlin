package com.example.fragments.view

import com.example.fragments.model.Hotel

interface HotelListView {
    fun showHotels(hotels: List<Hotel>)
    fun showHotelDetails(hotel: Hotel)
    fun showDeleteMode()
    fun hideDeleteMode()
    fun showSelectedHotels(hotels: List<Hotel>)
    fun updateSelectionCountText(count: Int)
}

