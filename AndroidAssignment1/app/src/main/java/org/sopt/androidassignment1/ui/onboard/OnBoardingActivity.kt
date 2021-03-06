package org.sopt.androidassignment1.ui.onboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.androidassignment1.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}