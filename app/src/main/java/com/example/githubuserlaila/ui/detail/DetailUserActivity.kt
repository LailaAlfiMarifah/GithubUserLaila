package com.example.githubuserlaila.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.githubuserlaila.R
import com.example.githubuserlaila.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_USERNAME = "extra_username"
    }

    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var viewModel: DetailUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_USERNAME)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DetailUserViewModel::class.java)

        if (username != null) {
            viewModel.setUserDetail(username)
        }

        viewModel.getUserDetail().observe(this, {
            if (it != null) {
                binding.apply {
                    tvName.text = it.name
                    tvUsername.text = it.login
                    tvBio.text = it.bio
                    tvFollowers.text = "${it.followers} Followers"
                    tvFollowing.text = "${it.following} Following"
                    Glide.with(this@DetailUserActivity)
                        .load(it.avatar_url)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .centerCrop()
                        .into(ivProfile)
                }
            }
        })

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        binding.apply {
            viewPager.adapter = sectionPagerAdapter
            tabs.setupWithViewPager(viewPager)
        }
    }
}