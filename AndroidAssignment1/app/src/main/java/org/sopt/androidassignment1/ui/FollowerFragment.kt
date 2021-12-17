package org.sopt.androidassignment1.ui

import android.graphics.Color.rgb
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import org.sopt.androidassignment1.config.CustomDecoration
import org.sopt.androidassignment1.config.ItemTouchHelperCallback
import org.sopt.androidassignment1.adpater.FollowerViewAdapter
import org.sopt.androidassignment1.databinding.FragmentFollowerBinding
import org.sopt.androidassignment1.model.ResponseFollowerData
import org.sopt.androidassignment1.model.ResponseGIthubUserData
import org.sopt.androidassignment1.model.TripleData
import org.sopt.androidassignment1.service.ServiceCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowerFragment : Fragment() {
    private var _binding: FragmentFollowerBinding? = null
    private val binding get() = _binding!!
    private lateinit var followerViewAdapter: FollowerViewAdapter
    private val followerList = mutableListOf<TripleData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)

        initFollowerList()

        initAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initFollowerList(){
       // followerList.clear()
        val callFollowers: Call<List<ResponseFollowerData>> = ServiceCreator.githubService.getFollowers("gimangi")



        callFollowers.enqueue(object: Callback<List<ResponseFollowerData>>{
            override fun onResponse(
                call: Call<List<ResponseFollowerData>>,
                response: Response<List<ResponseFollowerData>>
            ) {
                if(response.isSuccessful){
                    val resbody = response.body()!!
                    for(i in resbody.indices){
                        val login = resbody[i].login
                        val imgUrl = resbody[i].avatar_url

                        // user bio (소개)를 불러오기 위한 call
                        ServiceCreator
                            .githubService
                            .getUser(login)
                            .enqueue(object: Callback<ResponseGIthubUserData>{
                                override fun onResponse(
                                    call: Call<ResponseGIthubUserData>,
                                    res: Response<ResponseGIthubUserData>
                                ) {

                                    if(res.isSuccessful){
                                        var newDat: TripleData
                                        if (res != null && res.body()!!.bio != null)
                                            newDat = TripleData(login, res.body()!!.bio, imgUrl)
                                        else
                                            newDat = TripleData(login, "", imgUrl)
                                        followerList.add(newDat)
                                    }
                                    else{
                                        Log.e("Network err", "response fail")
                                    }
                                }
                                override fun onFailure(
                                    call: Call<ResponseGIthubUserData>,
                                    t: Throwable
                                ) {
                                    Log.e("Network err", "error:$t")
                                }

                            })

                    }
                }
                else{
                    Toast.makeText(context, "팔로워 리스트를 불러오지 못했습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ResponseFollowerData>>, t: Throwable) {
                Log.e("Network err", "error:$t")
            }

        })




    }

    private fun initAdapter(){
        val decoration = CustomDecoration(1.0f, 0.0f, rgb(221,226,229))
        binding.rvFollower.addItemDecoration(decoration)

        followerViewAdapter = FollowerViewAdapter()

        binding.rvFollower.adapter = followerViewAdapter

        followerViewAdapter.datalist.addAll(followerList)
        followerViewAdapter.notifyDataSetChanged()

        ItemTouchHelper(ItemTouchHelperCallback(followerViewAdapter)).attachToRecyclerView(binding.rvFollower)

    }


}