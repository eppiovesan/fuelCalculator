package com.comunidadedevspace.imc


import com.comunidadedevspace.imc.R
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
import com.comunidadedevspace.imc.template.fuelCalculator
import com.comunidadedevspace.imc.voltarTelaAnterior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class DistanceActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distance)

        val bt_voltar = findViewById<Button>(R.id.btn_voltar)
        val bt_continuar = findViewById<Button>(R.id.btn_continuar)
        var edt_distance = findViewById<TextInputEditText>(R.id.edt_distance)

        bt_voltar.setOnClickListener {
            buttonVoltar()
        }

        bt_continuar.setOnClickListener {
            buttonContinuar()
        }

    }

    private fun setDistance(): TextInputEditText? {
        var edtDistance =  findViewById<TextInputEditText>(R.id.edt_distance)

        if (edtDistance.text.toString().isNotEmpty()){
            return edtDistance
        }
        else {
            Snackbar
                .make(
                    edtDistance,
                    "Preencha a distância do percurso",
                    Snackbar.LENGTH_LONG
                ).show()
            return null
        }
    }
    private fun buttonContinuar(){
        var viewModel = (application as fuelCalculator).sharedViewModel
        var edtDistance = setDistance()
        if (edtDistance != null){
            val distance = edtDistance.text.toString().toFloat()
            viewModel.distance = distance
            startActivity(Intent(this, ResultActivity::class.java))
        }
    }

    private fun buttonVoltar(){
        voltarTelaAnterior(this)
    }

}