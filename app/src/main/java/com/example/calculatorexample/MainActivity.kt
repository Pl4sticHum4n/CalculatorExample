package com.example.calculatorexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculatorexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Jetpack view binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)

        binding.buttonER.setOnClickListener {
            binding.Entrada.setText(binding.Entrada.text.dropLast(1))

        }

        binding.buttonC.setOnClickListener {
            binding.Entrada.text.clear()

        }

        binding.buttonIgual.setOnClickListener{
            when(operator){
                "Multiplicacion" -> {
                    binding.Entrada.setText("${firstValue * binding.Entrada.text.toString().toDouble()}")
                }
                "Division" -> {
                    binding.Entrada.setText("${firstValue / binding.Entrada.text.toString().toDouble()}")
                }
                "Adittion" -> {
                    binding.Entrada.setText("${firstValue + binding.Entrada.text.toString().toDouble()}")
                }
                "Sustraccion" -> {
                    binding.Entrada.setText("${firstValue - binding.Entrada.text.toString().toDouble()}")
                }
            }
        }

        binding.buttonPorc.setOnClickListener{
            binding.Entrada.setText("${binding.Entrada.text.toString().toDouble() / 100}")
        }
    }

    fun numberBtnClicked(view: View){
        val button = view as Button
        when(button.id){
            binding.buttonPunto.id -> {
                if (!binding.Entrada.text.contains('.')){
                    binding.Entrada.text.append(".")
                }
            }
            binding.button0.id -> { binding.Entrada.text.append("0") }
            binding.button1.id -> { binding.Entrada.text.append("1") }
            binding.button2.id -> { binding.Entrada.text.append("2") }
            binding.button3.id -> { binding.Entrada.text.append("3") }
            binding.button4.id -> { binding.Entrada.text.append("4") }
            binding.button5.id -> { binding.Entrada.text.append("5") }
            binding.button6.id -> { binding.Entrada.text.append("6") }
            binding.button7.id -> { binding.Entrada.text.append("7") }
            binding.button8.id -> { binding.Entrada.text.append("8") }
            binding.button9.id -> { binding.Entrada.text.append("9") }
            else -> {Toast.makeText( this, "Igual", Toast.LENGTH_LONG).show()}
        }
    }

    fun opClick(view: View){
        val button = view as Button
        operator = when(button.id){
            binding.buttonMult.id -> {"Multiplicacion"}
            binding.buttonDiv.id -> {"Division"}
            binding.buttonMas.id -> {"Adittion"}
            binding.buttonRest.id -> {"Sustraccion"}
            else -> {""}
        }
        firstValue = binding.Entrada.text.toString().toDouble()
        binding.Entrada.text.clear()
    }

}