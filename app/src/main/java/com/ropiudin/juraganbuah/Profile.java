package com.ropiudin.juraganbuah;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ahmadsobur.recyclerviewuas.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
private lateinit var binding: ActivityProfileBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        }
        }