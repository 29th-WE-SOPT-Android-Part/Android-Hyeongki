package org.sopt.androidassignment1

import android.view.MotionEvent
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeFragmentViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment){
    val fragments = mutableListOf<Fragment>()
    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]

}