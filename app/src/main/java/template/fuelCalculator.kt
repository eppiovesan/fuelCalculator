package com.comunidadedevspace.imc.template
import android.app.Application
import com.comunidadedevspace.imc.sharedViewModel

class fuelCalculator: Application() {
    lateinit var sharedViewModel: sharedViewModel

    override fun onCreate() {
        super.onCreate()
        sharedViewModel = sharedViewModel()
    }

}