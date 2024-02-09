package com.example.calclove62.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.calclove62.CounterViewModel
import com.example.calclove62.LoveViewModel
import com.example.calclove62.SecondActivity
import com.example.calclove62.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoveViewModel by viewModels()
    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickListeners()
    }

    private fun initClickListeners() {
        with(binding){
            calculateBtn.setOnClickListener {
                val firstName = binding.editTxtFirst.text.toString()
                val secondName = binding.editTxtSecond.text.toString()

                viewModel.getLove(firstName, secondName)
                    .observe(this@MainActivity, Observer { loveModel ->
                        loveModel?.let { model ->
                            val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                                putExtra("firstName", firstName)
                                putExtra("secondName", secondName)
                                putExtra("percentage", model.percentage)
                                putExtra("result", model.result)
                            }
                            startActivity(intent)
                        }
                    })
            }

            incrementButton.setOnClickListener {
                counterViewModel.increment()
                binding.counterTextView.text = counterViewModel.number.toString()
            }

            decrementButton.setOnClickListener {
                counterViewModel.decrement()
                binding.counterTextView.text = counterViewModel.number.toString()
            }
        }
    }
}

