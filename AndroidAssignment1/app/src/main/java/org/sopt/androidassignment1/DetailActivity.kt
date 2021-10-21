package org.sopt.androidassignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.androidassignment1.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)

        initMatchName()

        setContentView(binding.root)
    }

    private fun initMatchName(){
        name = intent.getStringExtra("name").toString()

        binding.tvDetailName.text = name

        when(name){
            "김형기"-> setDetail(R.drawable.profile_image, R.string.detail_khk)
            "고틀린"-> setDetail(R.drawable.img_kotlin, R.string.detail_kot)
            "김자바"-> setDetail(R.drawable.img_java, R.string.detail_jav)
            "이안드"-> setDetail(R.drawable.img_android, R.string.detail_and)
            "박알고"-> setDetail(R.drawable.img_algorithm, R.string.detail_alg)
        }

    }

    private fun setDetail(img_src: Int, detail_text: Int){
        binding.ivProfile.setImageResource(img_src)
        binding.tvDetailContent.text = getString(detail_text)
    }
}