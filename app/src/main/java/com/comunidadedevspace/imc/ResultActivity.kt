package com.comunidadedevspace.imc

import android.R.color
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetDialog

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

        val bt_recalcular = findViewById<Button>(R.id.bt_Recalcular)

        bt_recalcular.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // iniciando a MainActivity
            startActivity(intent)
            // fechar a tela de Result Activity para evitar empilhamento
            finish()

        }
        val ic_info = findViewById<ImageView>(R.id.ic_info)

        ic_info.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
            builder
                //icone de informação
                .setIcon(R.drawable.ic_info_2)
                // titulo
                .setTitle("Classificação")
                // botao ok
                .setNeutralButton("OK"){dialog, which ->}
                // texto exibido
                .setItems(arrayOf("MAGREZA: menor que 18.5",
                                  "NORMAL: de 18.5 até 24.9",
                                  "SOBREPESO: de 25.0 até 29.9",
                                  "OBESIDADE: de 30.0 até 39.9",
                                  "OBESIDADE GRAVE: maior que 40.0")
                                 ){dialog, which ->}
            val dialog: AlertDialog = builder.create()
            dialog.window?.apply {
                setGravity(Gravity.BOTTOM)
                attributes.y = 350
            }
            dialog.show()

        }






    }


}