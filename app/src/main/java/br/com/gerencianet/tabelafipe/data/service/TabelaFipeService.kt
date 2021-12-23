package br.com.gerencianet.tabelafipe.data.service

import br.com.gerencianet.tabelafipe.data.model.ManufacturerResponse
import retrofit2.http.GET

interface TabelaFipeService {
    @GET("carros/marcas")
    suspend fun getManufacturers(): List<ManufacturerResponse>
}
