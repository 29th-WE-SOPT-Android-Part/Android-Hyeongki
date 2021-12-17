package org.sopt.androidassignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.androidassignment1.databinding.ActivitySignUpBinding

class OnBoarding : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}