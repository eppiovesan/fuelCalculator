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
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.comunidadedevspace.imc.template.fuelCalculator

class PriceFuelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price_fuel)

        val bt_continuar = findViewById<Button>(R.id.btn_continuar)
        val bt_voltar = findViewById<Button>(R.id.btn_voltar)
        var viewModel = (application as fuelCalculator).sharedViewModel

        bt_continuar.setOnClickListener {
            buttonContinuar()
        }

        bt_voltar.setOnClickListener {
            buttonVoltar()
        }
    }

    private fun setFuelPrice(): TextInputEditText? {
        var edtPrice = findViewById<TextInputEditText>(R.id.edt_price_fuel)

        if (edtPrice.text.toString().isNotEmpty()) {
            return edtPrice
        } else {
            Snackbar
                .make(
                    edtPrice,
                    "Preencha o preço do combustível",
                    Snackbar.LENGTH_LONG
                ).show()
            return null
        }
    }
    private fun buttonContinuar() {
        var viewModel = (application as fuelCalculator).sharedViewModel
        var edtPrice = setFuelPrice()
        if (edtPrice != null) {
            val fuelPrice = edtPrice.text.toString().toFloat()
            viewModel.priceFuel = fuelPrice
            startActivity(Intent(this, FuelConsumptionActivity::class.java))
        }
    }

    private fun buttonVoltar(){
        voltarTelaAnterior(this)
    }
}