package org.sopt.androidassignment1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.androidassignment1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        initFragmentTransactionEvent()

        setContentView(binding.root)
    }

    private fun initFragmentTransactionEvent(){
        val fragment1 = FollowerFragment()
        val fragment2 = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.home_fragment_container, fragment1).commit()

        binding.btnFollower.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.home_fragment_container, fragment1).commit()
        }
        binding.btnRepository.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.home_fragment_container, fragment2).commit()
        }
    }

}