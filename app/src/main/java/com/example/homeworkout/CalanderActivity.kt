package com.example.homeworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworkout.Entity.Calander
import com.example.homeworkout.databinding.ActivityCalanderBinding
import com.example.homeworkout.databinding.ActivityMainBinding

class CalanderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalanderBinding
    lateinit var viewModel: CalanderViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalanderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.CalanderPageToolBar)
        val actionBar=supportActionBar
        if(actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        binding.CalanderPageToolBar.setNavigationOnClickListener {
            onBackPressed()
        }


        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=RVadapter(this)
        binding.recyclerView.adapter=adapter
        viewModel=ViewModelProvider(this).get(CalanderViewModel::class.java)

        viewModel.allCalander.observe(this, Observer {
            it?.let {
                adapter.updateList(it)
            }
        })

    }
}