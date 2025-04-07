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
import com.comunidadedevspace.imc.DistanceActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.comunidadedevspace.imc.CalculoViewModel
import com.comunidadedevspace.imc.template.fuelCalculator
import com.comunidadedevspace.imc.PriceFuelActivity


class FuelConsumptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuel_consumption)

        val bt_voltar = findViewById<Button>(R.id.btn_voltar)
        val bt_continuar = findViewById<Button>(R.id.btn_continuar)
        var viewModel = (application as fuelCalculator).sharedViewModel



        bt_voltar.setOnClickListener {
            buttonVoltar()
        }

        bt_continuar.setOnClickListener {
            buttonContinuar()
        }
    }

        //campo edit

    private fun setFuelConsumption(): TextInputEditText? {
        var edtConsumption = findViewById<TextInputEditText>(R.id.edt_fuel_consumption)

        if (edtConsumption.text.toString().isNotEmpty()){
            return edtConsumption
        }
        else{
            Snackbar
                .make(
                    edtConsumption,
                    "Preencha  o consumo do veículo",
                    Snackbar.LENGTH_LONG
                ).show()
            return null
        }

    }

    private fun buttonContinuar(){
        var viewModel = (application as fuelCalculator).sharedViewModel
        var  edtConsumption = setFuelConsumption()
        if (edtConsumption != null){
            val consumption = edtConsumption.text.toString().toFloat()
            viewModel.consumptionFuel = consumption
            startActivity(Intent(this, DistanceActivity::class.java ))
        }
    }

    private fun buttonVoltar(){
        voltarTelaAnterior(this)
    }

}