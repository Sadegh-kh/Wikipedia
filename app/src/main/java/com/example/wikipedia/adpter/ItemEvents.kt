package com.example.wikipedia.adpter

import com.example.wikipedia.data.ItemPost

interface ItemEvents {
    fun onItemClick(itemPost: ItemPost)
}