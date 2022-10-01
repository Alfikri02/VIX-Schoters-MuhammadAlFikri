package com.example.mynewsapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mynewsapi.databinding.ItemCardviewNewsBinding
import com.example.mynewsapi.model.Article

class CardNewsAdapter(val listNews: ArrayList<Article>) :
    RecyclerView.Adapter<CardNewsAdapter.CardViewHolder>() {

    class CardViewHolder(private val binding: ItemCardviewNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Article) {
            binding.apply {
                Glide.with(binding.root)
                    .load(data.urlToImage)
                    .into(imgNews)
                tvNewsTitle.text = data.title
                tvNewsTitle.text = data.publishedAt
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CardViewHolder(ItemCardviewNewsBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val article = listNews[position]
        article.let { holder.bind(article) }

    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}