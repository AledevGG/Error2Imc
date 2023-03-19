package com.master.error2imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.master.error2imc.MainActivity.Companion.IMC_KEY

class ResultActivity : AppCompatActivity() {
    private lateinit var tvResult:TextView
    private lateinit var tvImc:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnRecalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvImc.text = result.toString()
        when(result){
            in 0.00..18.50 -> {
                tvResult.text = getString(R.string.title_thinness)
                tvDescription.text = getString(R.string.description_thinness)
            }
            in 18.51..24.99 -> {
                tvResult.text = getString(R.string.title_weight_normal)
                tvDescription.text = getString(R.string.description_normal)
            }
            in 25.00..29.99 -> {
                tvResult.text = getString(R.string.title_overweight)
                tvDescription.text = getString(R.string.description_overweight)
            }
            in 30.00..99.00 -> {
                tvResult.text = getString(R.string.title_obesity)
                tvDescription.text = getString(R.string.description_obesity)
            }
            else -> {
                tvImc.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvImc = findViewById(R.id.tvImc)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }
}