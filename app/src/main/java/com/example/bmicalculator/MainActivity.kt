package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.example.bmicalculator.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setListeners()
    }

    private fun setListeners() {
        binding.edWei.doAfterTextChanged { text ->
            Toast.makeText(
                this,
                text.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.button.setOnClickListener{
            calcIMC(binding.edWei.text.toString(), binding.edHei.text.toString())
        }
    }


    private fun calcIMC(weight: String, height: String) {
        val weight: Float? = weight.toFloatOrNull()
        val height: Float? = height.toFloatOrNull()
        if (weight != null && height != null) {
            val imc = weight / (height * height)
            //binding.result.visibility = "visible"
            binding.result.text = "Seu IMC é %.2f".format(imc)


        }
    }
}