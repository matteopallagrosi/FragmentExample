package com.ebookfrenzy.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(), ToolbarFragment.ToolbarListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonClick(fontsize: Int, text: String) {
        //l'activity passa i valori di fontsize e text a TextFragment
        val textFragment = supportFragmentManager.findFragmentById(R.id.text_fragment) as TextFragment
        textFragment.changeTextProperties(fontsize, text)
    }
}