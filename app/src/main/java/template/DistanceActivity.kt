package com.comunidadedevspace.imc.template


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
import com.comunidadedevspace.imc.template.DistanceActivity
import com.comunidadedevspace.imc.voltarTelaAnterior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class DistanceActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distance)

        val bt_voltar = findViewById<Button>(R.id.btn_voltar)

        bt_voltar.setOnClickListener {
            voltarTelaAnterior(this)
        }



    }



}