package com.example.calclove62

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calclove62.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstName = intent.getStringExtra("firstName")
        val secondName = intent.getStringExtra("secondName")
        val percentage = intent.getStringExtra("percentage")
        val result = intent.getStringExtra("result")


        binding.percentageTextView.text = percentage
        binding.resultTextView.text = "${firstName} \n ${secondName} \n ${result}"
    }
}