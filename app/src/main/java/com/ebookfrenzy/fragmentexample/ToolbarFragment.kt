package com.ebookfrenzy.fragmentexample

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.ebookfrenzy.fragmentexample.databinding.FragmentToolbarBinding
import java.lang.ClassCastException

class ToolbarFragment : Fragment(), SeekBar.OnSeekBarChangeListener {

    private lateinit var binding: FragmentToolbarBinding

    var seekValue = 10

    var activityCallback: ToolbarFragment.ToolbarListener? = null

    interface ToolbarListener {
        fun onButtonClick(position: Int, text: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallback = context as ToolbarListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + "must implement ToolbarListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentToolbarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.seekBar1.setOnSeekBarChangeListener(this)
        binding.button1.setOnClickListener { v ->
            buttonClicked(v)
        }
    }

    private fun buttonClicked(view: View) {
        activityCallback?.onButtonClick(seekValue, binding.editText1.text.toString())
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        seekValue = progress
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }
}