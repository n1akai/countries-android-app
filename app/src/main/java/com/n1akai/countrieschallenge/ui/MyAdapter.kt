package com.n1akai.countrieschallenge.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.n1akai.countrieschallenge.data.Country
import com.n1akai.countrieschallenge.databinding.ItemCountryBinding

class MyAdapter : PagingDataAdapter<Country, MyAdapter.CountryViewHolder>(COUNTRY_COMPARATOR) {
    class CountryViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.apply {
                Glide.with(itemView)
                    .load(country.flags.png)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imageView2)
                name.text = country.name.official
                population.text = country.population.toString()
                region.text = country.region
                capital.text = country.capital[0]
            }
        }
    }

    companion object {
        private val COUNTRY_COMPARATOR = object : DiffUtil.ItemCallback<Country>() {
            override fun areItemsTheSame(oldItem: Country, newItem: Country) = oldItem.name.official == newItem.name.official

            override fun areContentsTheSame(oldItem: Country, newItem: Country) = oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }
}