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
import com.comunidadedevspace.imc.template.DistanceActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText


class FuelConsumptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuel_consumption)

        //campo edit
        var edtConsumption = findViewById<TextInputEditText>(R.id.edt_fuel_consumption)

        // botão voltar
        val bt_voltar = findViewById<Button>(R.id.btn_voltar)
        bt_voltar.setOnClickListener {
            voltarTelaAnterior(this)
        }

        // botão continuar
        val bt_continuar = findViewById<Button>(R.id.btn_continuar)
        bt_continuar.setOnClickListener {
            var fuelConsuptionstr: String = edtConsumption.text.toString()
            // verificando se o campo não está vazio
            if (fuelConsuptionstr.isNotEmpty()){
                // convertendo o valor
                var consuption: Float = fuelConsuptionstr.toFloat()
                val intent = Intent(this, DistanceActivity::class.java)
                // armazenando o valor para usar no cálculo
                intent.putExtra(KEY_CONSUPTION_FUEL, consuption)
                // chamando a próxima tela
                startActivity(intent)

            }
            // se o edit estiver vazio
            else{
                Snackbar
                    .make(
                        edtConsumption,
                        "Preencha o consumo do veículo",
                        Snackbar.LENGTH_LONG
                    ).show()
            }
        }
    }
}