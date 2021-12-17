package org.sopt.androidassignment1.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.androidassignment1.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}