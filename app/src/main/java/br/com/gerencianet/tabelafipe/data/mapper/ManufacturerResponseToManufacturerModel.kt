package br.com.gerencianet.tabelafipe.data.mapper

import br.com.gerencianet.tabelafipe.base.BaseMapper
import br.com.gerencianet.tabelafipe.data.model.ManufacturerResponse
import br.com.gerencianet.tabelafipe.domain.model.ManufacturerModel

object ManufacturerResponseToManufacturerModel :
    BaseMapper<ManufacturerResponse, ManufacturerModel>() {
    override fun transformTo(source: ManufacturerResponse): ManufacturerModel {
        return ManufacturerModel(
            id = source.code.toLong(),
            name = source.name
        )
    }
}
