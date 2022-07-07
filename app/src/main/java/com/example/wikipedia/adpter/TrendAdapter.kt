package com.example.wikipedia.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ItemTrendBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdapter(private val data:ArrayList<ItemPost>,val itemEvents: ItemEvents):RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {
    lateinit var binding:ItemTrendBinding
    inner class TrendViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun binder(itemPost:ItemPost){
            val glide=Glide.with(itemView.context)
                .load(itemPost.imgUrl)
                .transform(RoundedCornersTransformation(26,8))
                .into(binding.imgTrendMain)
            binding.txtTrendTitel.text=itemPost.txtTitle
            binding.txtTrendInsight.text=itemPost.insight
            binding.txtTrendSubtitle.text=itemPost.txtSubtitle
            binding.txtTrendInsight.text=itemPost.insight
            binding.txtTrendNumber.text=(adapterPosition+1).toString()
            itemView.setOnClickListener {
                itemEvents.onItemClick(itemPost)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        binding= ItemTrendBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return TrendViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        holder.binder(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }
}