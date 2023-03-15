package com.RivskyInc.wallpy.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.RivskyInc.wallpy.CategoryListActivity
import com.RivskyInc.wallpy.WallpaperDetailActivity
import com.RivskyInc.wallpy.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)

        binding.textButtonNature.setOnClickListener {
            val intent = Intent(this@CategoryFragment.context, WallpaperDetailActivity::class.java)

            startActivity(intent)

        }
       val  buttonMinimalism =   binding.buttonMinimalism
        val text = SpannableString("M I N I M A L I S M ")
        // make "Clicks" (characters 0 to 5) Red
        // make "Clicks" (characters 0 to 5) Red
        text.setSpan(ForegroundColorSpan(Color.BLACK), 0, 10, 0)
        // make "Here" (characters 6 to 10) Blue
        // make "Here" (characters 6 to 10) Blue
        text.setSpan(ForegroundColorSpan(Color.WHITE), 11, 16, 0)
        // shove our styled text into the Button
        // shove our styled text into the Button
        buttonMinimalism.setText(text, TextView.BufferType.SPANNABLE)


        binding.textButtonNature.setOnClickListener {

            val nature = "nature wallpapers hd"
            val intent = Intent(this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java)
            intent.putExtra("category", nature )
            startActivity(intent)

        }

        binding.buttonSpace.setOnClickListener {

            val space = "space wallpapers hd"
            val intent = Intent(this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java)
            intent.putExtra("category", space )
            startActivity(intent)

        }

        return binding.root
    }
}
