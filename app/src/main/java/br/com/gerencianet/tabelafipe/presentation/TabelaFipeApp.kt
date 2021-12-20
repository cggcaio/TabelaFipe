package br.com.gerencianet.tabelafipe.presentation

import android.app.Application
import br.com.gerencianet.tabelafipe.di.AppComponent
import br.com.gerencianet.tabelafipe.di.DaggerAppComponent

class TabelaFipeApp : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}
