package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    // Recuperando os componentes em tela

            // EditText - criar variável e associar ao componente visual
    var edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
    var edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

            // Button - criar variável e associar ao componente visual
    val btCalcular = findViewById<Button>(R.id.bt_calcular)

    // ação do botão
    btCalcular.setOnClickListener {
        //recuperar o texto digitado


        var pesoStr: String = edtPeso.text.toString()
        var alturaStr : String = edtAltura.text.toString()

        //validando se os campos estão preenchido
        if (pesoStr.isNotEmpty() && alturaStr.isNotEmpty()){
            var peso: Float = pesoStr.toFloat()
            var altura: Float = alturaStr.toFloat()

            var alturaQ2: Float = altura * altura
            var resultado: Float = peso / alturaQ2


            // classificação
            var classificacao: String? = null
            if (resultado < 18.5f){
                classificacao = "MAGREZA"
            }
            else if (resultado >=18.5f && resultado <= 24.9f){
                classificacao = "NORMAL"
            }
            else if (resultado >=25f && resultado <= 29.9f){
                classificacao = "SOBREPESO"
            }
            else if (resultado >=30f && resultado <= 39.9f){
                classificacao = "OBESIDADE"
            }
            else {
                classificacao = "OBESIDADE GRAVE"
            }

            // navegar para próxima tela
                // criando a intent
                val intent = Intent(this,ResultActivity:: class.java)
                // enviando o resultado obtido para a outra tela
                // a KEY_RESULT_IMC é uma constante criada no arquivo ResultActivity para enviar corretamente a informação do resultado
                intent.putExtra(KEY_RESULT_IMC, resultado)
                intent.putExtra(KEY_CLASSIFICACAO_IMC, classificacao)
                startActivity(intent)


            println("Seu IMC é: " + resultado)
        }
        else{
            //mostrar mensagem ao usuário
            Snackbar
                .make(
                    edtPeso,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()


        }





        //validar se todos os campos foram preenchidos

    }


    }
}
