package com.example.learnapplication.ui.home

import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.learnapplication.MainActivity
import com.example.learnapplication.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

//     private fun initButtons(){
//
//        binding.button1.setOnClickListener {
//            Toast.makeText(activity, binding.button1.text, Toast.LENGTH_SHORT).show()
//        }
//        binding.button2.setOnClickListener {
//            Toast.makeText(activity, binding.button2.text, Toast.LENGTH_SHORT).show()
//        }
//        binding.button3.setOnClickListener {
//            Toast.makeText(activity, binding.button3.text, Toast.LENGTH_SHORT).show()
//        }
//        binding.button4.setOnClickListener {
//            Toast.makeText(activity, binding.button4.text, Toast.LENGTH_SHORT).show()
//        }
//        binding.button5.setOnClickListener {
//            Toast.makeText(activity, binding.button5.text, Toast.LENGTH_SHORT).show()
//        }
//    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
//        initButtons()



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}