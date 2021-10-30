package org.sopt.androidassignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.androidassignment1.databinding.FragmentFollowerBinding
import org.sopt.androidassignment1.databinding.FragmentHome1Binding

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
            //setting button click listener
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