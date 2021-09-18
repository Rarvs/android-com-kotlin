package com.example.hotel


//singleton object.
object MemoryRepository : HotelRepository {
    //nextId increments every time a new hotel object is added to the hotels list
    private var nextId = 1L
    //hotels list
    private val hotelsList = mutableListOf<Hotel>()

    //some hotels for testing
    init {
        save(Hotel(0, "New Beach Hotel", "Av. Boa Viagem", 4.5f))
        save(Hotel(0, "Recife Hotel", "Av. Boa Viagem", 4.0f))
        save(Hotel(0, "Canario Hotel", "Rua dos Navegantes", 3.0f))
        save(Hotel(0, "Byanca Beach Hotel", "Rua Mamanguape", 4.0f))
        save(Hotel(0, "Grand Hotel Dor", "Av. Bernardo", 3.5f))
        save(Hotel(0, "Hotel Cool", "Av. Conselheiro Aguiar", 4.0f))
        save(Hotel(0, "Hotel Infinito", "Rua Ribeiro de Brito", 5.0f))
        save(Hotel(0, "Hotel Tulipa", "Av. Boa Viagem", 5.0f))
    }

    override fun save(hotel: Hotel) {
        //checks if new hotel has an id of 0 and adds to the list if true
        if (hotel.id == 0L) {
            hotel.id = nextId++
            hotelsList.add(hotel)
        } else {
            //if hotels already exists, id != 0, then we search for said hotel e update its parameters
            val index = hotelsList.indexOfFirst { it.id == hotel.id }
            if (index > -1) {
                hotelsList[index] = hotel
            } else {
                hotelsList.add(hotel)
            }
        }
    }

    override fun remove(vararg hotels: Hotel) {
        hotelsList.removeAll(hotels)
    }

    override fun hotelById(id: Long, callback: (Hotel?) -> Unit) {
        callback(hotelsList.find { it.id == id })
    }

    override fun search(term: String, callback: (List<Hotel>) -> Unit) {
        callback(
            if (term.isEmpty()) hotelsList
            else hotelsList.filter {
                it.name.toUpperCase().contains(term.toUpperCase())
            }
        )
    }
}