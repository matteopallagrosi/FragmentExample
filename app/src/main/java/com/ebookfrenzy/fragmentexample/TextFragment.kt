package com.ebookfrenzy.fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.fragmentexample.databinding.FragmentTextBinding

class TextFragment : Fragment() {

    private lateinit var binding: FragmentTextBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentTextBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    fun changeTextProperties(fontsize: Int, text: String) {
        binding.textView1.textSize = fontsize.toFloat()
        binding.textView1.text = text
    }


}