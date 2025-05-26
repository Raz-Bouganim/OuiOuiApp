package com.sharks.ouioui.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sharks.ouioui.data.model.PlaceShort
import com.sharks.ouioui.databinding.ItemPlaceBinding

class PlacesAdapter : ListAdapter<PlaceShort, PlacesAdapter.PlaceViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding = ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = getItem(position)
        holder.bind(place)
    }

    inner class PlaceViewHolder(private val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(place: PlaceShort) {
            binding.placeName.text = place.name ?: "(No name)"
            binding.placeKind.text = place.kinds ?: ""

            // future image support (Using Glide, need to uncomment the code below)
            // Glide.with(binding.placeImage.context)
            //     .load(place.imageUrl)
            //     .placeholder(R.drawable.placeholder)
            //     .into(binding.placeImage)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<PlaceShort>() {
        override fun areItemsTheSame(oldItem: PlaceShort, newItem: PlaceShort): Boolean {
            return oldItem.xid == newItem.xid
        }

        override fun areContentsTheSame(oldItem: PlaceShort, newItem: PlaceShort): Boolean {
            return oldItem == newItem
        }
    }
}