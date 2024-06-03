package com.example.pj0601_soundremake

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pj0601_soundremake.databinding.ActivityMainBinding
import com.example.pj0601_soundremake.databinding.ActivitySettingBinding

private lateinit var binding: ActivitySettingBinding
class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgShowTutorial.setOnClickListener {
            val intent = Intent(this, TutorialActivity::class.java)
            startActivity(intent)
        }
        binding.imgBack.setOnClickListener {
            finish()
        }

    }
}