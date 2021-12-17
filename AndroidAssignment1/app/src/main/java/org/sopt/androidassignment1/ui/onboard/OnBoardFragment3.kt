package org.sopt.androidassignment1.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidassignment1.databinding.FragmentOnBoard3Binding

class OnBoardFragment3 : Fragment() {
    private var _binding: FragmentOnBoard3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoard3Binding.inflate(layoutInflater, container, false)

        return binding.root
    }
}