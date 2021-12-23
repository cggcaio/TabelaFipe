package br.com.gerencianet.tabelafipe.data.repository

import br.com.gerencianet.tabelafipe.data.mapper.ManufacturerResponseToManufacturerModel
import br.com.gerencianet.tabelafipe.data.service.TabelaFipeService
import br.com.gerencianet.tabelafipe.domain.model.ManufacturerModel
import br.com.gerencianet.tabelafipe.domain.repository.FipeRepository
import javax.inject.Inject

class FipeRepositoryImpl @Inject constructor(private val mTabelaFipeService: TabelaFipeService) :
    FipeRepository {
    override suspend fun getManufacturerList(): List<ManufacturerModel> {
       return ManufacturerResponseToManufacturerModel.transformToList(mTabelaFipeService.getManufacturers())
    }
}
