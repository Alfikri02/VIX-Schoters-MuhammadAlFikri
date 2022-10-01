package com.example.mynewsapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewsapi.adapter.CardNewsAdapter
import com.example.mynewsapi.model.Article

class MainActivity : AppCompatActivity() {
    private lateinit var rvNews: RecyclerView
    private var list: ArrayList<Article> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNews = findViewById(R.id.rv_news)
        rvNews.setHasFixedSize(true)

        //list.addAll(a)
        showRecyclerView()
    }

    private fun showRecyclerView() {
        rvNews.layoutManager = LinearLayoutManager(this)
        val cardNewsAdapter = CardNewsAdapter(list)
        rvNews.adapter = cardNewsAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.bookmark -> {
                val intent = Intent(this@MainActivity, BookmarkActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.profile -> {
                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(intent)
                true
            }
            else -> false
        }
    }
}