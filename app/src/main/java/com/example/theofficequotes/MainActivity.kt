package com.example.theofficequotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.theofficequotes.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getQuote()

        binding.nextBtn.setOnClickListener {
            getQuote()
        }
    }

    private fun getQuote() {
        setInProgress(true)
        GlobalScope.launch {
            try {
                val response = RetrofitInstance.quoteApi.getRandomQuote()
                runOnUiThread {
                    setInProgress(false)
                    response.body()?.let {
                        setUI(it)
                    }
                }
            } catch (e : Exception) {
                e.printStackTrace() // This will print the full error in logcat
                runOnUiThread {
                    setInProgress(false)
                    Toast.makeText(applicationContext, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setUI(quote : QuoteModel) {
        binding.quoteTv.text = quote.quote
        binding.authorTv.text = quote.character
    }

    private fun setInProgress(inProgress : Boolean) {
        if(inProgress) {
            binding.progressBar.visibility = View.VISIBLE
            binding.nextBtn.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.nextBtn.visibility = View.VISIBLE
        }
    }
}