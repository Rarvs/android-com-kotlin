package com.example.hotel

data class Hotel(
    var id: Long = 0,
    var name: String = "",
    var address: String = "",
    var rating: Float = 0.0F
) {
    override fun toString(): String = name
}

interface HotelRepository {
    fun save(hotel: Hotel)
    fun remove(vararg hotel: Hotel)
    fun hotelById(id: Long, callback: (Hotel?) -> Unit)
    fun search(term: String, callback: (List<Hotel>) -> Unit)
}

