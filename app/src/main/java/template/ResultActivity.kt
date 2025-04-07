package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.comunidadedevspace.imc.R
import com.comunidadedevspace.imc.KEY_PRICE_FUEL
import com.comunidadedevspace.imc.KEY_CONSUPTION_FUEL
import com.comunidadedevspace.imc.KEY_DISTANCE
import com.comunidadedevspace.imc.template.fuelCalculator

// USAR VIEW MODEL para armazenar dados de uma tela para outra

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val viewModel = (application as fuelCalculator).sharedViewModel


        val gasto = viewModel.calculaGasto()
        val price = viewModel.priceFuel
        val consumption = viewModel.consumptionFuel
        val distance = viewModel.distance


        val tv_gasto = findViewById<TextView>(R.id.resultado_gasto)
        val tv_price = findViewById<TextView>(R.id.tv_PriceValue)
        val tv_consumption = findViewById<TextView>(R.id.tv_ConsumptionValue)
        val tv_distance = findViewById<TextView>(R.id.tv_DistanceValue)

        tv_gasto.text = gasto.toString()
        tv_price.text = price.toString()
        tv_consumption.text = consumption.toString()
        tv_distance.text = distance.toString()





        val bt_recalcular = findViewById<Button>(R.id.btn_recalcular)
        bt_recalcular.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }



    }




}