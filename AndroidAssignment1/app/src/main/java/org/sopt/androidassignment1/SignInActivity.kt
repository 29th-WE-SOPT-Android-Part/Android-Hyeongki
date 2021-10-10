package org.sopt.androidassignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidassignment1.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)

        binding.btnSignin.setOnClickListener{
            val idInput = binding.etId.text
            val pwInput = binding.etPw.text

            if(idInput.isNotBlank() && pwInput.isNotBlank()){
                Toast.makeText(this, "김형기님 환영합니다", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
        }

        binding.btnSignup.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        setContentView(binding.root)
    }
}