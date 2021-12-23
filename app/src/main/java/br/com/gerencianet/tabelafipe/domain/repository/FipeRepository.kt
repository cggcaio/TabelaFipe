package br.com.gerencianet.tabelafipe.domain.repository

import br.com.gerencianet.tabelafipe.domain.model.ManufacturerModel

interface FipeRepository {
    suspend fun getManufacturerList(): List<ManufacturerModel>
}