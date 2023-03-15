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

        val buttonMinimalism = binding.buttonMinimalism
        val text = SpannableString("M I N I M A L I S M ")
        text.setSpan(ForegroundColorSpan(Color.BLACK), 0, 10, 0)
        text.setSpan(ForegroundColorSpan(Color.WHITE), 11, 16, 0)
        buttonMinimalism.setText(text, TextView.BufferType.SPANNABLE)
        
        binding.buttonNature.setOnClickListener {

            val nature = "nature wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", nature)
            startActivity(intent)

        }

        binding.buttonSpace.setOnClickListener {

            val space = "space wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", space)
            startActivity(intent)

        }
        binding.buttonMinimalism.setOnClickListener {

            val minimalism = "minimalism wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", minimalism)
            startActivity(intent)

        }
        binding.buttonBlack.setOnClickListener {

            val black = "black wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", black)
            startActivity(intent)

        }
        binding.buttonAnimal.setOnClickListener {

            val animals = "animals wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", animals)
            startActivity(intent)

        }
        binding.buttonCars.setOnClickListener {

            val cars = "cars wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", cars)
            startActivity(intent)

        }
        binding.buttonSky.setOnClickListener {

            val sky = "sky wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", sky)
            startActivity(intent)

        }

        binding.buttonMotivation.setOnClickListener {

            val motivation = "motivation"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", motivation)
            startActivity(intent)

        }


        return binding.root
    }
}
