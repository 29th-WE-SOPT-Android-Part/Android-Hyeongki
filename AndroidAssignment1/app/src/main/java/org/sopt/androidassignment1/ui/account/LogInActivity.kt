package org.sopt.androidassignment1.ui.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.androidassignment1.data.SOPTSharedPreferences
import org.sopt.androidassignment1.databinding.ActivityLogInBinding
import org.sopt.androidassignment1.model.RequestLoginData
import org.sopt.androidassignment1.model.ResponseLoginData
import org.sopt.androidassignment1.service.ServiceCreator
import org.sopt.androidassignment1.ui.home.HomeActivity
import org.sopt.androidassignment1.util.shortToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLogInBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogInBinding.inflate(layoutInflater)

        getResultText = registerForActivityResult (
            ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK) {
                binding.etId.text = result.data?.getStringExtra("id")?.toEditable()
                binding.etPw.text = result.data?.getStringExtra("pw")?.toEditable()
            }
        }


        initClickListener()
        checkAutoLogin()

        setContentView(binding.root)
    }

    private fun initClickListener() {
        binding.btnSignin.setOnClickListener{
            val idInput = binding.etId.text
            val pwInput = binding.etPw.text

            if(idInput.isNotBlank() && pwInput.isNotBlank()){
                initNetWork()

            }
            else
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
        }

        binding.btnSignup.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)

            getResultText.launch(intent)

        }
    }

    private fun checkAutoLogin() {
        if (SOPTSharedPreferences.getAutoLogin(this)) {
            shortToast("자동 로그인 되었습니다")
            startActivity(Intent(this@LogInActivity, HomeActivity::class.java))
            finish()
        }
    }

    private fun initNetWork() {
        val requestLoginData = RequestLoginData(
            email = binding.etId.text.toString(),
            password = binding.etPw.text.toString()
        )

        val call: Call<ResponseLoginData> = ServiceCreator.loginService.postLogin(requestLoginData)

        call.enqueue(object: Callback<ResponseLoginData>{
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ){
              if(response.isSuccessful){
                  val data = response.body()?.data

                  shortToast("${data?.email}님 반갑습니다!")
                  startActivity(Intent(this@LogInActivity, HomeActivity::class.java))
              }else{
                  shortToast("로그인에 실패하였습니다.")
              }

            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
}