package org.sopt.androidassignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.androidassignment1.databinding.FragmentGithubFollowerBinding
import org.sopt.androidassignment1.databinding.FragmentGithubFollowingBinding
import org.sopt.androidassignment1.databinding.FragmentHome2Binding

/* HomeActivity -> Fragment <Home> */
class HomeFragment2 : Fragment() {
    private var _binding: FragmentHome2Binding? = null
    private val binding get() = _binding?: error("Binding not init")
    private lateinit var homeFragmentViewPagerAdapter: HomeFragmentViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHome2Binding.inflate(layoutInflater, container, false)

        initAdapter()
        initTabLayout()

        return binding.root
    }

    private fun initAdapter(){
        val fragmentList = listOf(GithubFollowerFragment(), GithubFollowingFragment())

        homeFragmentViewPagerAdapter = HomeFragmentViewPagerAdapter(this)
        homeFragmentViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpHome.adapter = homeFragmentViewPagerAdapter
    }

    private fun initTabLayout(){
        val tabLabel = listOf("팔로잉", "팔로워")

        TabLayoutMediator(binding.tlHome, binding.vpHome){ tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}