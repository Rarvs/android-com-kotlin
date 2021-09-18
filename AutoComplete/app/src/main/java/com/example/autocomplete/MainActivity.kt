package com.example.autocomplete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cities = listOf<String>(
            "Poços de Caldas",
            "Poço Fundo",
            "Roropópó",
            "Botelhos",
            "Andradas",
            "Bandeira",
            "Palmeiral"
        )

        val adapter = CitySearchAdapter(this, android.R.layout.simple_dropdown_item_1line, cities)
        autoCompleteCities.setAdapter(adapter)
    }
}