package com.RivskyInc.wallpy.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.RivskyInc.wallpy.API.Photo
import com.RivskyInc.wallpy.databinding.ItemRawWallpaperBinding
import com.RivskyInc.wallpy.fragments.HomeFragment
import com.bumptech.glide.Glide

class Adapter : RecyclerView.Adapter<Adapter.WallpaperViewHolder>() {

    var list = ArrayList<Photo>()
    lateinit var context_ : Context

    fun setWallpaperData(list: ArrayList<Photo>, context: HomeFragment){
        this.list = list
        context_ = context.requireContext()

        notifyDataSetChanged()

    }

    class  WallpaperViewHolder(val binding : ItemRawWallpaperBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperViewHolder {

        return WallpaperViewHolder(ItemRawWallpaperBinding.inflate(LayoutInflater
            .from(parent.context),parent, false ))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WallpaperViewHolder, position: Int) {
     Glide.with(holder.itemView).load(list[position].src.portrait).into(holder.binding.imageViewRaw)
    }
}