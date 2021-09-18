package com.example.audioplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.audioplayer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val playButton: Button = binding.playButton
        val pauseButton: Button = binding.pauseButton
        val halfButton: Button = binding.halfButton

        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.sample1)

        playButton.setOnClickListener {
            playButton.isEnabled = false
            mediaPlayer.start()
        }

        halfButton.setOnClickListener {
            mediaPlayer.seekTo(mediaPlayer.duration / 2)
        }

        pauseButton.setOnClickListener {
            mediaPlayer.pause()
            playButton.isEnabled = true
        }

        mediaPlayer.setOnCompletionListener {
            Toast.makeText(this,"Fim", Toast.LENGTH_SHORT).show()
            playButton.isEnabled = true
        }
    }
}