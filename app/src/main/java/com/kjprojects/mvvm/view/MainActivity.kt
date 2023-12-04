package com.kjprojects.mvvm.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.kjprojects.mvvm.databinding.ActivityMainBinding
import com.kjprojects.mvvm.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]

        binding.calculateBt.setOnClickListener {
            val num1 = binding.value1.text.toString().toIntOrNull() ?: 0
            val num2 = binding.value2.text.toString().toIntOrNull() ?: 0

            val result = calculatorViewModel.calculateSum(num1, num2)
            binding.answerText.text = "${result.sum}"
        }
    }
}