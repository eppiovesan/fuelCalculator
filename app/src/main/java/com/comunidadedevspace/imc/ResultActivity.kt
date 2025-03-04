package com.comunidadedevspace.imc

import android.R.color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"
const val KEY_CLASSIFICACAO_IMC = "ResultActivity.KEY_IMC_CLASSIF"
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        // getFloatExtra exige valor para default
        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val classificacao = intent.getStringExtra(KEY_CLASSIFICACAO_IMC)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao =  findViewById<TextView>(R.id.tv_classificacao)

        // convertendo o resultado que é float para um string
        tvResult.text = result.toString()
        tvClassificacao.text = classificacao


        val cor = when (classificacao){
            "NORMAL" -> ContextCompat.getColor(this, R.color.primary650 )
            else -> ContextCompat.getColor(this, R.color.red)
        }
        tvClassificacao.setTextColor(cor)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}