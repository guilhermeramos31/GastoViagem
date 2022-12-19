package com.GuilhermeRamos31.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.GuilhermeRamos31.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),  View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalc.setOnClickListener(this)
    }
    override fun onClick(view: View) {
        if(view.id == R.id.button_calc){
            calculate()
        }
    }
    private fun isValid(): Boolean{
        return((binding.editDistance.text.toString() != ""
                && binding.editDistance.text.toString().toFloat() != 0f)
                && (binding.editPrice.text.toString() != ""
                && binding.editPrice.text.toString().toFloat() != 0f)
                && (binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
                )
    }
    private fun calculate(){
        if (isValid()){
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            val value = (distance*price)/autonomy

            binding.textValor.text = "R$ ${"%.2f".format(value)}"
        } else {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
        }
    }
}