package org.sopt.androidassignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidassignment1.databinding.FragmentRepositoryBinding

class RepositoryFragment : Fragment() {
    private var _binding: FragmentRepositoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var repositoryViewAdapter: RepositoryViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryBinding.inflate(layoutInflater, container, false)

        initAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter(){
        repositoryViewAdapter = RepositoryViewAdapter()

        binding.rvRepository.adapter = repositoryViewAdapter

        repositoryViewAdapter.dataList.addAll(
            listOf(
                PairData("안드로이드 과제 레포지토리", "안드로이드 파트 과제"),
                PairData("알고리즘 레포지토리", "백준 알고리즘 공부"),
                PairData("코틀린 과제 레포지토리", "코틀린 스터디 과제"),
                PairData("서버 레포지토리", "스프링 공부"),
                PairData("DB 레포지토리", "SQL 공부"),
                PairData("프로젝트 레포지토리", "안드로이드 개발 팀 프로젝트")
            )
        )
    }
}