package org.sopt.androidassignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidassignment1.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {
    private var _binding: FragmentFollowerBinding? = null
    private val binding get() = _binding!!
    private lateinit var followerAdapter: FollowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)

        initAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter(){
        followerAdapter = FollowerAdapter()

        binding.rvFollower.adapter = followerAdapter

        followerAdapter.followerlist.addAll(
            listOf(
                FollowerData("김형기", "YB 29기 김형기"),
                FollowerData("홍길동", "ㅇㄹ"),
                FollowerData("이정재", "쌍문동"),
                FollowerData("멋쟁이", "ㅇㄴㄹ")
            )
        )
        followerAdapter.notifyDataSetChanged()
    }

}