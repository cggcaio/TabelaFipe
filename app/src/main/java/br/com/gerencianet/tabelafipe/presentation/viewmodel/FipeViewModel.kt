package br.com.gerencianet.tabelafipe.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gerencianet.tabelafipe.base.BaseUseCase
import br.com.gerencianet.tabelafipe.domain.model.ManufacturerModel
import br.com.gerencianet.tabelafipe.domain.usecase.GetManufacturersListUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FipeViewModel @Inject constructor(
    private val mGetManufacturersListUseCase: GetManufacturersListUseCase
) : ViewModel() {

    private val mManufacturerList = MutableLiveData<List<ManufacturerModel>>()

    fun getManufacturerList() {
        mGetManufacturersListUseCase.produce(BaseUseCase.None).map {
            mManufacturerList.value = it
        }.catch { error ->
            Log.d("Error", error.message ?: "")
        }.launchIn(viewModelScope)
    }
}
