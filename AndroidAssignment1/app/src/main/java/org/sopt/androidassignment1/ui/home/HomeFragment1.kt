package org.sopt.androidassignment1.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import org.sopt.androidassignment1.R
import org.sopt.androidassignment1.databinding.FragmentHome1Binding
import org.sopt.androidassignment1.ui.detail.FollowerFragment
import org.sopt.androidassignment1.ui.detail.RepositoryFragment

/* HomeActivity -> Fragment <Profile> */
class HomeFragment1 : Fragment() {
    private var _binding: FragmentHome1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHome1Binding.inflate(layoutInflater, container, false)

        initProfileImg()
        initListener()
        initFragmentTransaction()

        return binding.root
    }


    private fun initProfileImg(){
        Glide.with(this)
            .load(getString(R.string.img_url_test))
            .circleCrop()
            .into(binding.ivProfile)
    }

    private fun initListener(){
        binding.btnSetting.setOnClickListener{
            val intent = Intent(context, SettingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initFragmentTransaction(){
        val fragment1 = FollowerFragment()
        val fragment2 = RepositoryFragment()

        parentFragmentManager.beginTransaction().add(R.id.home_fragment_container, fragment1).commit()
        binding.btnFollower.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.home_fragment_container, fragment1).commit()
        }
        binding.btnRepository.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.home_fragment_container, fragment2).commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}