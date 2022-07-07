package com.example.wikipedia.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ActivityMain2Binding
import com.example.wikipedia.fragments.FragmentTest
import com.example.wikipedia.fragments.SEND_DATA_TO_SECOND_ACTIVITY
import java.net.URI

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar2)
        binding.collapsMain.setExpandedTitleColor(
            ContextCompat.getColor(this, android.R.color.transparent)
        )
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)

        if (dataPost != null) {
            showData(dataPost)

        }

    }

    private fun showData(dataPost: ItemPost) {
        binding.txtTitleActivity2.text = dataPost.txtTitle
        binding.txtDetailActivity2.text = dataPost.txtDetail
        val glide = Glide.with(this).load(dataPost.imgUrl).into(binding.imgActivity2)
        binding.txtSubtitleActivity2.text = dataPost.txtSubtitle

        binding.fabOpenWikipediaWeb.setOnClickListener {
            val url = "https://en.wikipedia.org/wiki/Main_Page"

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }
}