package com.example.homeworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homeworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnStart.setOnClickListener {
            val intent= Intent(this,ExcersiseScreen::class.java)
            startActivity(intent)

        }
        binding.btnBmi.setOnClickListener {
            val intent= Intent(this,BMIActivity::class.java)
            startActivity(intent)
        }
        binding.btnCalander.setOnClickListener {
            val intent= Intent(this,CalanderActivity::class.java)
            startActivity(intent)
        }
    }
}