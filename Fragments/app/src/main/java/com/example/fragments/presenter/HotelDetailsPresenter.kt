package com.example.fragments.presenter

import com.example.fragments.model.HotelRepository
import com.example.fragments.view.HotelDetailsView

class HotelDetailsPresenter(
    private val view: HotelDetailsView,
    private val repository: HotelRepository
) {
    fun loadHotelDetails(id: Long) {
        repository.hotelById(id) { hotel ->
            if (hotel != null) {
                view.showHotelDetails(hotel)
            }else{
                view.errorHotelNotFound()
            }
        }
    }
}