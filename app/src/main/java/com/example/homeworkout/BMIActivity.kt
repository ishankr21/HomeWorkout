package com.example.homeworkout

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.homeworkout.databinding.ActivityBmiactivityBinding
import com.example.homeworkout.databinding.ActivityExcersiseScreenBinding

class BMIActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBmiactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiactivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.bmiPageToolBar)
        val actionBar=supportActionBar
        if(actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        binding.bmiPageToolBar.setNavigationOnClickListener {
            onBackPressed()
        }
        setupTabLayout()

    }

    private fun setupTabLayout() {
        val adapter=ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(BMIkgFragment(),"In metric Units")
        adapter.addFragment(BMIpoundFragment(),"In pound Units")
        binding.viewPager.adapter=adapter
        val viewPager:ViewPager=findViewById(R.id.viewPager)
        binding.tabLayout.setupWithViewPager(viewPager)
    }
}