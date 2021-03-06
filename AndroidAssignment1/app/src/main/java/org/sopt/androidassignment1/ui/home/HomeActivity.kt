package org.sopt.androidassignment1.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import org.sopt.androidassignment1.R
import org.sopt.androidassignment1.adpater.HomeViewPagerAdapter
import org.sopt.androidassignment1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var homeViewPagerAdapter: HomeViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        initAdpater()
        initBottomNavigation()

        setContentView(binding.root)
    }



    private fun initAdpater(){
        val fragmentList = listOf(HomeFragment1(), HomeFragment2(), HomeFragment3())

        homeViewPagerAdapter = HomeViewPagerAdapter(this)
        homeViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpHome.adapter = homeViewPagerAdapter
    }

    private fun initBottomNavigation() {
        binding.vpHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                binding.bnvHome.menu.getItem(position).isChecked = true
            }
        })

        binding.bnvHome.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_profile -> binding.vpHome.currentItem = FIRST_FRAGMENT
                R.id.menu_home -> binding.vpHome.currentItem = SECOND_FRAGMENT
                else -> binding.vpHome.currentItem = THIRD_FRAGMENT
            }
            return@setOnItemSelectedListener true
        }
    }


    companion object{
        const val FIRST_FRAGMENT = 0
        const val SECOND_FRAGMENT = 1
        const val THIRD_FRAGMENT = 2
    }

}