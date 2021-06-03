package com.example.homeworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.homeworkout.Entity.Calander
import com.example.homeworkout.databinding.ActivityCongoScreenBinding
import com.example.homeworkout.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CongoScreen : AppCompatActivity() {
    private lateinit var binding: ActivityCongoScreenBinding
    lateinit var viewModel: CalanderViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCongoScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.CongoPageToolBar)
        val actionBar=supportActionBar
        if(actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        binding.CongoPageToolBar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatted = current.format(formatter)
        var stringDate:String=formatted.toString()

        //Toast.makeText(this,stringDate,Toast.LENGTH_LONG).show()
        viewModel= ViewModelProvider(this).get(CalanderViewModel::class.java)
        val c= Calander(stringDate)

        viewModel.insertCal(c)

        binding.checkCalander.setOnClickListener {
            val intent = Intent(this, CalanderActivity::class.java)
            startActivity(intent)

        }
    }
}