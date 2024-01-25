package com.example.calclove62

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calclove62.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickListeners()
    }

    private fun initClickListeners() {
        with(binding){
            calculateBtn.setOnClickListener {
                RetrofitService().api.getCompatibility(
                    editTxtFirst.text.toString(),
                    editTxtSecond.text.toString()
                ).enqueue(object:retrofit2.Callback<LoveModel>{
                    @SuppressLint("SetTextI18n")
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if(response.isSuccessful){
                            response.body()?.let {
                                //textView.text="${it.percentage} \n ${it.result}"
                                val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                                    putExtra("percentage", it.percentage)
                                    putExtra("result", it.result)
                                }
                                startActivity(intent)
                            }
                        }
                    }
                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo","on Failure: ${t.message}")
                    }
                })
            }
        }
    }
}