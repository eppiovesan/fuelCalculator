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
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText


class PriceFuelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price_fuel)

        var edtPrice = findViewById<TextInputEditText>(R.id.edt_price_fuel)

        //botão voltar
        val bt_voltar = findViewById<Button>(R.id.btn_voltar)

        bt_voltar.setOnClickListener {
            voltarTelaAnterior(this)
        }


        // botão continuar
        val bt_continuar = findViewById<Button>(R.id.btn_continuar)
        bt_continuar.setOnClickListener {
            var priceFuelstr: String = edtPrice.text.toString()
            //verificando se o campo não está vazio
            if (priceFuelstr.isNotEmpty()){
                // convertendo o valor do campo
                var price: Float =  priceFuelstr.toFloat()
                //armazenando o valor do campo e passando para outra tela
                val intent2 = Intent(this,FuelConsumptionActivity::class.java)
                intent2.putExtra(KEY_PRICE_FUEL, price )
                startActivity(intent2)

            }
            //se o campo estiver vazio
            else{
                //mostrar mensagem ao usuário
                Snackbar
                    .make(
                        edtPrice,
                        "Preencha o preço do combustível",
                        Snackbar.LENGTH_LONG
                    ).show()
            }




        }




    }
}