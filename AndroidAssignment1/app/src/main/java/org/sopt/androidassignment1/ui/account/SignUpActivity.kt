package org.sopt.androidassignment1.ui.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidassignment1.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        binding.btnSignupSubmit.setOnClickListener{
            val nameInput = binding.etName.text
            val idInput = binding.etId.text
            val pwInput = binding.etPw.text

            if(nameInput.isNotBlank() && idInput.isNotBlank() && pwInput.isNotBlank()) {
                Toast.makeText(this, "회원가입의 완료되었습니다", Toast.LENGTH_SHORT).show()

                // register for activity result
                val resultIntent = Intent(this, LogInActivity::class.java)
                resultIntent.putExtra("id", idInput.toString())
                resultIntent.putExtra("pw", pwInput.toString())
                setResult(RESULT_OK, resultIntent)

                finish()
            }
            else
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
        }


        setContentView(binding.root)
    }
}