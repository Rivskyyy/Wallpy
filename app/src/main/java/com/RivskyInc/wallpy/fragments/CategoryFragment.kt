package com.RivskyInc.wallpy.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.RivskyInc.wallpy.CategoryListActivity
import com.RivskyInc.wallpy.R
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

        val animation = AnimationUtils.loadAnimation(this@CategoryFragment.requireContext(),
            androidx.transition.R.anim.abc_grow_fade_in_from_bottom)

        binding.buttonNature.setOnClickListener {

           binding.buttonNature.startAnimation(animation)

            val nature = "nature wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", nature)
            startActivity(intent)

        }

        binding.buttonSpace.setOnClickListener {

            binding.buttonSpace.startAnimation(animation)

            val space = "space wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", space)
            startActivity(intent)

        }
        binding.buttonMinimalism.setOnClickListener {

            binding.buttonMinimalism.startAnimation(animation)

            val minimalism = "minimalism wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", minimalism)
            startActivity(intent)

        }
        binding.buttonBlack.setOnClickListener {

            binding.buttonBlack.startAnimation(animation)

            val black = "black wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", black)
            startActivity(intent)

        }
        binding.buttonAnimal.setOnClickListener {

            binding.buttonAnimal.startAnimation(animation)

            val animals = "animals wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", animals)
            startActivity(intent)

        }
        binding.buttonCars.setOnClickListener {

            binding.buttonCars.startAnimation(animation)

            val cars = "cars wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", cars)
            startActivity(intent)

        }
        binding.buttonSky.setOnClickListener {

            binding.buttonSky.startAnimation(animation)

            val sky = "sky wallpapers hd"
            val intent = Intent(
                this@CategoryFragment.requireContext(),
                CategoryListActivity::class.java
            )
            intent.putExtra("category", sky)
            startActivity(intent)

        }

        binding.buttonMotivation.setOnClickListener {

            binding.buttonMotivation.startAnimation(animation)

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
