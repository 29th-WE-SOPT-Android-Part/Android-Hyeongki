package org.sopt.androidassignment1.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.androidassignment1.data.SOPTSharedPreferences
import org.sopt.androidassignment1.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingBinding.inflate(layoutInflater)

        initBtn()
        initListener()

        setContentView(binding.root)
    }

    private fun initBtn() {
        if (SOPTSharedPreferences.getAutoLogin(this)) {
            
        }
    }

    private fun initListener() {

        // 자동 로그인
        binding.cbtnAutoLogin.setOnClickListener {
            if (binding.cbtnAutoLogin.isChecked) {

            }
            else {

            }
        }

    }
}