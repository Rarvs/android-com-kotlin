package com.example.hotel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.hotel.databinding.ActivityHotelDetailsBinding

class HotelDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHotelDetailsBinding

    private val hotelId: Long by lazy { intent.getLongExtra(EXTRA_HOTEL_ID, -1) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHotelDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if(savedInstanceState == null){
            showHotelDetailsFragment()
        }
    }
    private fun showHotelDetailsFragment(){
        val fragment = HotelDetailsFragment.newInstance(hotelId)
        supportFragmentManager.beginTransaction().replace(R.id.details, fragment, HotelDetailsFragment.TAG_DETAILS).commit()
    }
    companion object{
        private const val EXTRA_HOTEL_ID = "hotel_id"
        fun open(context: Context, hotelId: Long){
            context.startActivity(Intent(context, HotelDetailsActivity::class.java).apply {
                putExtra(EXTRA_HOTEL_ID, hotelId)
            })
        }
    }
}

