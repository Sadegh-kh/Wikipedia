package com.example.wikipedia.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ItemExploreBinding

class ExploreAdapter(private val data: ArrayList<ItemPost>,val itemEvents: ItemEvents) :
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    lateinit var binding: ItemExploreBinding

    inner class ExploreViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        private val imgView = binding.imgExploreMain
        private val textTitle = binding.txtExploreTitle
        private val textSubtitle = binding.txtExploreSubtitle
        private val textDetail = binding.txtExploreDetail
        fun bindViews(ItemPost: ItemPost) {
            textTitle.text = ItemPost.txtTitle
            textSubtitle.text = ItemPost.txtSubtitle
            textDetail.text = ItemPost.txtDetail
            val glide = Glide.with(itemView.context)
                .load(ItemPost.imgUrl)
                .into(imgView)
            itemView.setOnClickListener {
                itemEvents.onItemClick(itemPost = ItemPost)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {

        binding = ItemExploreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExploreViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bindViews(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}