package org.sopt.androidassignment1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import org.sopt.androidassignment1.databinding.FragmentHome3Binding

/* HomeActivity -> Fragment Camera */
class HomeFragment3 : Fragment() {
    private var _binding: FragmentHome3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHome3Binding.inflate(layoutInflater, container, false)

        initListener()

        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE){
            if(resultCode == -1){
                Glide.with(requireContext()).load(data?.data).into(binding.ivAttached)
            }
        }
    }

    private fun initListener(){
        binding.btnAttachImg.setOnClickListener{
            val intent = Intent()
            intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT

            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    companion object{
        const val REQUEST_CODE = 1
    }

}