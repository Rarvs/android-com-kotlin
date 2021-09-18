package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var teamOneScore = 0
    private var teamTwoScore = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //View binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.team1Minus.setOnClickListener {
            teamOneScore -= 1
            onDataSetChanged()
        }
        binding.team1Plus.setOnClickListener {
            teamOneScore += 1
            onDataSetChanged()
        }

        binding.team2Minus.setOnClickListener {
            teamTwoScore -= 1
            onDataSetChanged()
        }
        binding.team2Plus.setOnClickListener {
            teamTwoScore += 1
            onDataSetChanged()
        }
    }

    private fun onDataSetChanged(){
        binding.team1Minus.isClickable = teamOneScore > 0
        binding.team2Minus.isClickable = teamTwoScore > 0
        binding.team1Points.text = teamOneScore.toString()
        binding.team2Points.text = teamTwoScore.toString()
    }
}