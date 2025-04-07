package com.comunidadedevspace.imc

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData // permite atualizar a interface do usuário automaticamente quando so valores mudam
import androidx.lifecycle.MutableLiveData // usada dentro do view model para atualizar os valores armazenados
import androidx.lifecycle.ViewModel

class CalculoViewModel: ViewModel() {

    private var inputFuelPrice = 0f
    // variável do tipo mutable live data para armazenar o preço do combustivel
    private val _fuelPrice = MutableLiveData<Float>()
    // variável que será escutada pela activity
    val fuelPrice: LiveData<Float> = _fuelPrice

    //função que recebe o valor digitado pelo usuario
    fun setFuelPrice (price: Float){
        this.inputFuelPrice = price
    }

    fun validateInputFuelPrice (){
        _fuelPrice.value = inputFuelPrice
    }




   // var fuelPrice : Float = 0f
   /* var consumption: Float = 0f
    var distance: Float = 0f
    var result: Float = 0f

    fun calculaGastoCombustivel () {
        result = (distance/consumption) * fuelPrice
    }*/

}