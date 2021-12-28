package br.com.gerencianet.tabelafipe.di

import android.content.Context
import br.com.gerencianet.tabelafipe.presentation.fragment.StartFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelBuilderModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        RetrofitModule::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun inject(fragment: StartFragment)
}
