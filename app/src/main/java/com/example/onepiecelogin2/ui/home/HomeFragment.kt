package com.example.onepiecelogin2.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onepiecelogin2.data.remote.response.IndodaxResponseItem
import com.example.onepiecelogin2.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    private val  binding get() = _binding
    private val viewModel: HomeViewModel by inject()
    private var list: ArrayList<IndodaxResponseItem> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        observeData()
        return binding.root
    }

    private fun observeData(){
        with(viewModel){
            observeMovie.observe(requireActivity()){
                it.let { data ->
                    list = data.body()!!
                    Log.d("home", "observeData: $list")
                    with(binding.rvMovie){
                        adapter = HomeAdapter(list)
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }
    }

    private fun init(){
        viewModel.getMovies()
    }
}