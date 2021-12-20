package br.com.gerencianet.tabelafipe.di

import androidx.lifecycle.ViewModel
import br.com.gerencianet.tabelafipe.presentation.viewmodel.FipeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

// Pra conhecer quem são as ViewModels pra poder injetar ela onde for necessário
@Module
interface ViewModelModule {
    @Binds
    @IntoMap()
    @ViewModelKey(FipeViewModel::class)
    fun bindFipeViewModel(viewModel: FipeViewModel): ViewModel
}
