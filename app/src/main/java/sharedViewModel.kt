package com.comunidadedevspace.imc

import androidx.lifecycle.ViewModel

class sharedViewModel: ViewModel() {
    var priceFuel: Float = 0f
    var consumptionFuel: Float = 0f
    var distance: Float = 0f


    fun calculaGasto(): Float {
        var gasto: Float = ((distance / consumptionFuel) * priceFuel)
        return gasto
    }

}